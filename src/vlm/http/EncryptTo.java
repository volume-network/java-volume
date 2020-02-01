package vlm.http;

import com.google.gson.JsonElement;
import vlm.Account;
import vlm.VolumeException;
import vlm.crypto.EncryptedData;
import vlm.services.AccountService;
import vlm.services.ParameterService;

import javax.servlet.http.HttpServletRequest;

import static vlm.http.JSONResponses.INCORRECT_RECIPIENT;
import static vlm.http.common.Parameters.*;

final class EncryptTo extends APIServlet.APIRequestHandler {

    private final ParameterService parameterService;
    private final AccountService accountService;

    EncryptTo(ParameterService parameterService, AccountService accountService) {
        super(new APITag[]{APITag.MESSAGES}, RECIPIENT_PARAMETER, MESSAGE_TO_ENCRYPT_PARAMETER, MESSAGE_TO_ENCRYPT_IS_TEXT_PARAMETER, SECRET_PHRASE_PARAMETER);
        this.parameterService = parameterService;
        this.accountService = accountService;
    }

    @Override
    JsonElement processRequest(HttpServletRequest req) throws VolumeException {

        long recipientId = ParameterParser.getRecipientId(req);
        Account recipientAccount = accountService.getAccount(recipientId);
        if (recipientAccount == null || recipientAccount.getPublicKey() == null) {
            return INCORRECT_RECIPIENT;
        }

        EncryptedData encryptedData = parameterService.getEncryptedMessage(req, recipientAccount, recipientAccount.getPublicKey());
        return JSONData.encryptedData(encryptedData);

    }

}
