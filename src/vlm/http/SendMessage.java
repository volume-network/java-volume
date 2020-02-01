package vlm.http;

import com.google.gson.JsonElement;
import vlm.Account;
import vlm.Attachment;
import vlm.VolumeException;
import vlm.services.ParameterService;

import javax.servlet.http.HttpServletRequest;

import static vlm.http.common.Parameters.RECIPIENT_PARAMETER;

final class SendMessage extends CreateTransaction {

    private final ParameterService parameterService;

    SendMessage(ParameterService parameterService, APITransactionManager apiTransactionManager) {
        super(new APITag[]{APITag.MESSAGES, APITag.CREATE_TRANSACTION}, apiTransactionManager, RECIPIENT_PARAMETER);
        this.parameterService = parameterService;
    }

    @Override
    JsonElement processRequest(HttpServletRequest req) throws VolumeException {
        long recipient = ParameterParser.getRecipientId(req);
        Account account = parameterService.getSenderAccount(req);
        return createTransaction(req, account, recipient, 0, Attachment.ARBITRARY_MESSAGE);
    }

}
