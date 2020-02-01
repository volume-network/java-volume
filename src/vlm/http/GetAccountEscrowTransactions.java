package vlm.http;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import vlm.Account;
import vlm.Escrow;
import vlm.VolumeException;
import vlm.services.EscrowService;
import vlm.services.ParameterService;

import javax.servlet.http.HttpServletRequest;
import java.util.Collection;

import static vlm.http.common.Parameters.ACCOUNT_PARAMETER;
import static vlm.http.common.Parameters.ESCROWS_RESPONSE;

public final class GetAccountEscrowTransactions extends APIServlet.APIRequestHandler {

    private final ParameterService parameterService;

    private final EscrowService escrowService;

    GetAccountEscrowTransactions(ParameterService parameterService, EscrowService escrowService) {
        super(new APITag[]{APITag.ACCOUNTS}, ACCOUNT_PARAMETER);
        this.parameterService = parameterService;
        this.escrowService = escrowService;
    }

    @Override
    JsonElement processRequest(HttpServletRequest req) throws VolumeException {
        final Account account = parameterService.getAccount(req);

        Collection<Escrow> accountEscrows = escrowService.getEscrowTransactionsByParticipant(account.getId());

        JsonObject response = new JsonObject();

        JsonArray escrows = new JsonArray();

        for (Escrow escrow : accountEscrows) {
            escrows.add(JSONData.escrowTransaction(escrow));
        }

        response.add(ESCROWS_RESPONSE, escrows);
        return response;
    }
}
