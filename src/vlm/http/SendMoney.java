package vlm.http;

import com.google.gson.JsonElement;
import vlm.Account;
import vlm.VolumeException;
import vlm.services.ParameterService;

import javax.servlet.http.HttpServletRequest;

import static vlm.http.common.Parameters.AMOUNT_NQT_PARAMETER;
import static vlm.http.common.Parameters.RECIPIENT_PARAMETER;

final class SendMoney extends CreateTransaction {

    private final ParameterService parameterService;

    SendMoney(ParameterService parameterService, APITransactionManager apiTransactionManager) {
        super(new APITag[]{APITag.ACCOUNTS, APITag.CREATE_TRANSACTION}, apiTransactionManager, RECIPIENT_PARAMETER, AMOUNT_NQT_PARAMETER);
        this.parameterService = parameterService;
    }

    @Override
    JsonElement processRequest(HttpServletRequest req) throws VolumeException {
        long recipient = ParameterParser.getRecipientId(req);
        long amountNQT = ParameterParser.getAmountNQT(req);
        Account account = parameterService.getSenderAccount(req);
        return createTransaction(req, account, recipient, amountNQT);
    }

}
