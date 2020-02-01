package vlm.http;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import vlm.Account;
import vlm.Blockchain;
import vlm.VolumeException;
import vlm.services.ParameterService;

import javax.servlet.http.HttpServletRequest;

import static vlm.http.common.Parameters.ACCOUNT_PARAMETER;
import static vlm.http.common.Parameters.COUNT_TYPE_PARAMETER;
import static vlm.http.common.ResultFields.*;

final class GetAccountTransactionCount extends APIServlet.APIRequestHandler {

    private final Blockchain blockchain;
    private final ParameterService parameterService;

    GetAccountTransactionCount(ParameterService parameterService, Blockchain blockchain) {
        super(new APITag[]{APITag.ACCOUNTS}, ACCOUNT_PARAMETER, COUNT_TYPE_PARAMETER);
        this.blockchain = blockchain;
        this.parameterService = parameterService;
    }

    @Override
    JsonElement processRequest(HttpServletRequest req) throws VolumeException {
        Account account = parameterService.getAccount(req);
        int countType = Integer.parseInt(req.getParameter(COUNT_TYPE_PARAMETER));
        if (account == null) {
            return JSONResponses.INCORRECT_ACCOUNT;
        }
        JsonObject response = new JsonObject();
        if (countType == 0) {
            response.addProperty(TOTAL_TRANSACTION_IN_RESPONSE, blockchain.getTransactionCount(account.getId(), countType));
        } else if (countType == 1) {
            response.addProperty(TOTAL_TRANSACTION_OUT_RESPONSE, blockchain.getTransactionCount(account.getId(), countType));
        } else {
            response.addProperty(TOTAL_TRANSACTION_RESPONSE, blockchain.getTransactionCount(account.getId(), countType));
        }

        return response;
    }

}
