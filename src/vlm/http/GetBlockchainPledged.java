package vlm.http;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import vlm.VolumeException;
import vlm.services.AccountService;

import javax.servlet.http.HttpServletRequest;

import static vlm.http.common.ResultFields.TOTAL_PLEDGE_RESPONSE;


public final class GetBlockchainPledged extends APIServlet.APIRequestHandler {

    private final AccountService accountService;

    GetBlockchainPledged(AccountService accountService) {
        super(new APITag[]{APITag.ACCOUNTS});
        this.accountService = accountService;
    }

    @Override
    JsonElement processRequest(HttpServletRequest req) throws VolumeException {
        JsonObject resp = new JsonObject();
        resp.addProperty(TOTAL_PLEDGE_RESPONSE, accountService.getAccountPledged());
        return resp;
    }

}
