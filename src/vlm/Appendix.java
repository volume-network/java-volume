package vlm;

import com.google.gson.JsonObject;
import com.google.protobuf.Any;
import com.google.protobuf.ByteString;
import vlm.crypto.EncryptedData;
import vlm.fluxcapacitor.FeatureToggle;
import vlm.grpc.proto.VlmApi;
import vlm.util.Convert;
import vlm.util.JSON;

import java.nio.ByteBuffer;
import java.util.Arrays;

public interface Appendix {

    int getSize();

    void putBytes(ByteBuffer buffer);

    JsonObject getJsonObject();

    byte getVersion();

    Any getProtobufMessage();

    abstract class AbstractAppendix implements Appendix {

        private final byte version;

        AbstractAppendix(JsonObject attachmentData) {
            version = JSON.getAsByte(attachmentData.get("version." + getAppendixName()));
        }

        AbstractAppendix(ByteBuffer buffer, byte transactionVersion) {
            version = (transactionVersion == 0) ? 0 : buffer.get();
        }

        AbstractAppendix(byte version) {
            this.version = version;
        }

        AbstractAppendix(int blockchainHeight) {
            //this.version = (byte)(Volume.getFluxCapacitor().isActive(FeatureToggle.DIGITAL_GOODS_STORE, blockchainHeight) ? 1 : 0);
            this.version = (byte) (Volume.getFluxCapacitor().isActive(FeatureToggle.DIGITAL_GOODS_STORE, blockchainHeight) ? 0 : 1);
        }

        abstract String getAppendixName();

        @Override
        public final int getSize() {
            return getMySize() + (version > 0 ? 1 : 0);
        }

        abstract int getMySize();

        @Override
        public final void putBytes(ByteBuffer buffer) {
            if (version > 0) {
                buffer.put(version);
            }
            putMyBytes(buffer);
        }

        abstract void putMyBytes(ByteBuffer buffer);

        @Override
        public final JsonObject getJsonObject() {
            JsonObject json = new JsonObject();
            if (version > 0) {
                json.addProperty("version." + getAppendixName(), version);
            }
            putMyJSON(json);
            return json;
        }

        abstract void putMyJSON(JsonObject json);

        @Override
        public final byte getVersion() {
            return version;
        }

        boolean verifyVersion(byte transactionVersion) {
            return transactionVersion == 0 ? version == 0 : version > 0;
        }

        public abstract void validate(Transaction transaction) throws VolumeException.ValidationException;

        public abstract void apply(Transaction transaction, Account senderAccount, Account recipientAccount);

    }

    class Message extends AbstractAppendix {

        private final byte[] message;
        private final boolean isText;
        public Message(ByteBuffer buffer, byte transactionVersion) throws VolumeException.NotValidException {
            super(buffer, transactionVersion);
            int messageLength = buffer.getInt();
            this.isText = messageLength < 0; // ugly hack
            if (messageLength < 0) {
                messageLength &= Integer.MAX_VALUE;
            }
            if (messageLength > Constants.MAX_ARBITRARY_MESSAGE_LENGTH) {
                throw new VolumeException.NotValidException("Invalid arbitrary message length: " + messageLength);
            }
            this.message = new byte[messageLength];
            buffer.get(this.message);
        }

        Message(JsonObject attachmentData) {
            super(attachmentData);
            String messageString = JSON.getAsString(attachmentData.get("message"));
            this.isText = Boolean.TRUE.equals(JSON.getAsBoolean(attachmentData.get("messageIsText")));
            this.message = isText ? Convert.toBytes(messageString) : Convert.parseHexString(messageString);
        }

        public Message(byte[] message, int blockchainHeight) {
            super(blockchainHeight);
            this.message = message;
            this.isText = false;
        }

        public Message(String string, int blockchainHeight) {
            super(blockchainHeight);
            this.message = Convert.toBytes(string);
            this.isText = true;
        }

        static Message parse(JsonObject attachmentData) {
            if (attachmentData.get("message") == null) {
                return null;
            }
            return new Message(attachmentData);
        }

        @Override
        String getAppendixName() {
            return "Message";
        }

        @Override
        int getMySize() {
            return 4 + message.length;
        }

        @Override
        void putMyBytes(ByteBuffer buffer) {
            buffer.putInt(isText ? (message.length | Integer.MIN_VALUE) : message.length);
            buffer.put(message);
        }

        @Override
        void putMyJSON(JsonObject json) {
            json.addProperty("message", isText ? Convert.toString(message) : Convert.toHexString(message));
            json.addProperty("messageIsText", isText);
        }

        @Override
        public void validate(Transaction transaction) throws VolumeException.ValidationException {
            if (this.isText && transaction.getVersion() < 0) {
                throw new VolumeException.NotValidException("Text messages not yet enabled");
            }
            if (transaction.getVersion() < 0 && transaction.getAttachment() != Attachment.ARBITRARY_MESSAGE) {
                throw new VolumeException.NotValidException("Message attachments not enabled for version 0 transactions");
            }
            if (message.length > Constants.MAX_ARBITRARY_MESSAGE_LENGTH) {
                throw new VolumeException.NotValidException("Invalid arbitrary message length: " + message.length);
            }
        }

        @Override
        public void apply(Transaction transaction, Account senderAccount, Account recipientAccount) {
        }

        public byte[] getMessage() {
            return message;
        }

        public boolean isText() {
            return isText;
        }

        @Override
        public Any getProtobufMessage() {
            return Any.pack(VlmApi.MessageAppendix.newBuilder()
                    .setVersion(super.getVersion())
                    .setMessage(ByteString.copyFrom(message))
                    .setIsText(isText)
                    .build());
        }
    }

    abstract class AbstractEncryptedMessage extends AbstractAppendix {

        private final EncryptedData encryptedData;
        private final boolean isText;

        private AbstractEncryptedMessage(ByteBuffer buffer, byte transactionVersion) throws VolumeException.NotValidException {
            super(buffer, transactionVersion);
            int length = buffer.getInt();
            this.isText = length < 0;
            if (length < 0) {
                length &= Integer.MAX_VALUE;
            }
            this.encryptedData = EncryptedData.readEncryptedData(buffer, length, Constants.MAX_ENCRYPTED_MESSAGE_LENGTH);
        }

        private AbstractEncryptedMessage(JsonObject attachmentJSON, JsonObject encryptedMessageJSON) {
            super(attachmentJSON);
            byte[] data = Convert.parseHexString(JSON.getAsString(encryptedMessageJSON.get("data")));
            byte[] nonce = Convert.parseHexString(JSON.getAsString(encryptedMessageJSON.get("nonce")));
            this.encryptedData = new EncryptedData(data, nonce);
            this.isText = Boolean.TRUE.equals(JSON.getAsBoolean(encryptedMessageJSON.get("isText")));
        }

        private AbstractEncryptedMessage(EncryptedData encryptedData, boolean isText, int blockchainHeight) {
            super(blockchainHeight);
            this.encryptedData = encryptedData;
            this.isText = isText;
        }

        @Override
        int getMySize() {
            return 4 + encryptedData.getSize();
        }

        @Override
        void putMyBytes(ByteBuffer buffer) {
            buffer.putInt(isText ? (encryptedData.getData().length | Integer.MIN_VALUE) : encryptedData.getData().length);
            buffer.put(encryptedData.getData());
            buffer.put(encryptedData.getNonce());
        }

        @Override
        void putMyJSON(JsonObject json) {
            json.addProperty("data", Convert.toHexString(encryptedData.getData()));
            json.addProperty("nonce", Convert.toHexString(encryptedData.getNonce()));
            json.addProperty("isText", isText);
        }

        @Override
        public Any getProtobufMessage() {
            return Any.pack(VlmApi.EncryptedMessageAppendix.newBuilder()
                    .setVersion(super.getVersion())
                    .setData(ByteString.copyFrom(encryptedData.getData()))
                    .setNonce(ByteString.copyFrom(encryptedData.getNonce()))
                    .setType(getType())
                    .build());
        }

        @Override
        public void validate(Transaction transaction) throws VolumeException.ValidationException {
            if (encryptedData.getData().length > Constants.MAX_ENCRYPTED_MESSAGE_LENGTH) {
                throw new VolumeException.NotValidException("Max encrypted message length exceeded");
            }
            if ((encryptedData.getNonce().length != 32 && encryptedData.getData().length > 0)
                    || (encryptedData.getNonce().length != 0 && encryptedData.getData().length == 0)) {
                throw new VolumeException.NotValidException("Invalid nonce length " + encryptedData.getNonce().length);
            }
        }

        public void apply(Transaction transaction, Account senderAccount, Account recipientAccount) {
        }

        public final EncryptedData getEncryptedData() {
            return encryptedData;
        }

        public final boolean isText() {
            return isText;
        }

        protected abstract VlmApi.EncryptedMessageAppendix.Type getType();
    }

    class EncryptedMessage extends AbstractEncryptedMessage {

        public EncryptedMessage(ByteBuffer buffer, byte transactionVersion) throws VolumeException.ValidationException {
            super(buffer, transactionVersion);
        }

        EncryptedMessage(JsonObject attachmentData) {
            super(attachmentData, JSON.getAsJsonObject(attachmentData.get("encryptedMessage")));
        }

        public EncryptedMessage(EncryptedData encryptedData, boolean isText, int blockchainHeight) {
            super(encryptedData, isText, blockchainHeight);
        }

        static EncryptedMessage parse(JsonObject attachmentData) {
            if (attachmentData.get("encryptedMessage") == null) {
                return null;
            }
            return new EncryptedMessage(attachmentData);
        }

        @Override
        String getAppendixName() {
            return "EncryptedMessage";
        }

        @Override
        void putMyJSON(JsonObject json) {
            JsonObject encryptedMessageJSON = new JsonObject();
            super.putMyJSON(encryptedMessageJSON);
            json.add("encryptedMessage", encryptedMessageJSON);
        }

        @Override
        public void validate(Transaction transaction) throws VolumeException.ValidationException {
            super.validate(transaction);
            if (!transaction.getType().hasRecipient()) {
                throw new VolumeException.NotValidException("Encrypted messages cannot be attached to transactions with no recipient");
            }
            if (transaction.getVersion() < 0) {
                throw new VolumeException.NotValidException("Encrypted message attachments not enabled for version 0 transactions");
            }
        }

        @Override
        protected VlmApi.EncryptedMessageAppendix.Type getType() {
            return VlmApi.EncryptedMessageAppendix.Type.TO_RECIPIENT;
        }

    }

    class EncryptToSelfMessage extends AbstractEncryptedMessage {

        public EncryptToSelfMessage(ByteBuffer buffer, byte transactionVersion) throws VolumeException.ValidationException {
            super(buffer, transactionVersion);
        }

        EncryptToSelfMessage(JsonObject attachmentData) {
            super(attachmentData, JSON.getAsJsonObject(attachmentData.get("encryptToSelfMessage")));
        }

        public EncryptToSelfMessage(EncryptedData encryptedData, boolean isText, int blockchainHeight) {
            super(encryptedData, isText, blockchainHeight);
        }

        static EncryptToSelfMessage parse(JsonObject attachmentData) {
            if (attachmentData.get("encryptToSelfMessage") == null) {
                return null;
            }
            return new EncryptToSelfMessage(attachmentData);
        }

        @Override
        String getAppendixName() {
            return "EncryptToSelfMessage";
        }

        @Override
        void putMyJSON(JsonObject json) {
            JsonObject encryptToSelfMessageJSON = new JsonObject();
            super.putMyJSON(encryptToSelfMessageJSON);
            json.add("encryptToSelfMessage", encryptToSelfMessageJSON);
        }

        @Override
        public void validate(Transaction transaction) throws VolumeException.ValidationException {
            super.validate(transaction);
            if (transaction.getVersion() < 0) {
                throw new VolumeException.NotValidException("Encrypt-to-self message attachments not enabled for version 0 transactions");
            }
        }

        @Override
        protected VlmApi.EncryptedMessageAppendix.Type getType() {
            return VlmApi.EncryptedMessageAppendix.Type.TO_SELF;
        }

    }

    class PublicKeyAnnouncement extends AbstractAppendix {

        private final byte[] publicKey;

        public PublicKeyAnnouncement(ByteBuffer buffer, byte transactionVersion) {
            super(buffer, transactionVersion);
            this.publicKey = new byte[32];
            buffer.get(this.publicKey);
        }

        PublicKeyAnnouncement(JsonObject attachmentData) {
            super(attachmentData);
            this.publicKey = Convert.parseHexString(JSON.getAsString(attachmentData.get("recipientPublicKey")));
        }

        public PublicKeyAnnouncement(byte[] publicKey, int blockchainHeight) {
            super(blockchainHeight);
            this.publicKey = publicKey;
        }

        static PublicKeyAnnouncement parse(JsonObject attachmentData) {
            if (attachmentData.get("recipientPublicKey") == null) {
                return null;
            }
            return new PublicKeyAnnouncement(attachmentData);
        }

        @Override
        String getAppendixName() {
            return "PublicKeyAnnouncement";
        }

        @Override
        int getMySize() {
            return 32;
        }

        @Override
        void putMyBytes(ByteBuffer buffer) {
            buffer.put(publicKey);
        }

        @Override
        void putMyJSON(JsonObject json) {
            json.addProperty("recipientPublicKey", Convert.toHexString(publicKey));
        }

        @Override
        public void validate(Transaction transaction) throws VolumeException.ValidationException {
            if (!transaction.getType().hasRecipient()) {
                throw new VolumeException.NotValidException("PublicKeyAnnouncement cannot be attached to transactions with no recipient");
            }
            if (publicKey.length != 32) {
                throw new VolumeException.NotValidException("Invalid recipient public key length: " + Convert.toHexString(publicKey));
            }
            long recipientId = transaction.getRecipientId();
            if (Account.getId(this.publicKey) != recipientId) {
                throw new VolumeException.NotValidException("Announced public key does not match recipient accountId");
            }
            if (transaction.getVersion() < 0) {
                throw new VolumeException.NotValidException("Public key announcements not enabled for version 0 transactions");
            }
            Account recipientAccount = Account.getAccount(recipientId);
            if (recipientAccount != null && recipientAccount.getPublicKey() != null && !Arrays.equals(publicKey, recipientAccount.getPublicKey())) {
                throw new VolumeException.NotCurrentlyValidException("A different public key for this account has already been announced");
            }
        }

        @Override
        public void apply(Transaction transaction, Account senderAccount, Account recipientAccount) {
            if (recipientAccount.setOrVerify(publicKey, transaction.getHeight())) {
                recipientAccount.apply(this.publicKey, transaction.getHeight());
            }
        }

        public byte[] getPublicKey() {
            return publicKey;
        }

        @Override
        public Any getProtobufMessage() {
            return Any.pack(VlmApi.PublicKeyAnnouncementAppendix.newBuilder()
                    .setVersion(super.getVersion())
                    .setRecipientPublicKey(ByteString.copyFrom(publicKey))
                    .build());
        }
    }
}
