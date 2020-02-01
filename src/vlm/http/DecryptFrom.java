package vlm.http;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import vlm.Account;
import vlm.VolumeException;
import vlm.crypto.EncryptedData;
import vlm.http.common.Parameters;
import vlm.services.ParameterService;
import vlm.util.Convert;

import javax.servlet.http.HttpServletRequest;

import static vlm.http.common.Parameters.*;
import static vlm.http.common.ResultFields.DECRYPTED_MESSAGE_RESPONSE;

public final class DecryptFrom extends APIServlet.APIRequestHandler {

    private static final Logger logger = LoggerFactory.getLogger(DecryptFrom.class);

    private final ParameterService parameterService;

    DecryptFrom(ParameterService parameterService) {
        super(new APITag[]{APITag.MESSAGES}, ACCOUNT_PARAMETER, DATA_PARAMETER, NONCE_PARAMETER, DECRYPTED_MESSAGE_IS_TEXT_PARAMETER, SECRET_PHRASE_PARAMETER);
        this.parameterService = parameterService;
    }

    @Override
    JsonElement processRequest(HttpServletRequest req) throws VolumeException {
        Account account = parameterService.getAccount(req);
        if (account.getPublicKey() == null) {
            return JSONResponses.INCORRECT_ACCOUNT;
        }
        String secretPhrase = ParameterParser.getSecretPhrase(req);
        byte[] data = Convert.parseHexString(Convert.nullToEmpty(req.getParameter(DATA_PARAMETER)));
        byte[] nonce = Convert.parseHexString(Convert.nullToEmpty(req.getParameter(NONCE_PARAMETER)));
        EncryptedData encryptedData = new EncryptedData(data, nonce);
        boolean isText = !Parameters.isFalse(req.getParameter(DECRYPTED_MESSAGE_IS_TEXT_PARAMETER));
        try {
            byte[] decrypted = account.decryptFrom(encryptedData, secretPhrase);
            JsonObject response = new JsonObject();
            response.addProperty(DECRYPTED_MESSAGE_RESPONSE, isText ? Convert.toString(decrypted) : Convert.toHexString(decrypted));
            return response;
        } catch (RuntimeException e) {
            logger.debug(e.toString());
            return JSONResponses.DECRYPTION_FAILED;
        }
    }

}
