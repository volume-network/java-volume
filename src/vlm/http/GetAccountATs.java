package vlm.http;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import vlm.Account;
import vlm.VolumeException;
import vlm.services.ATService;
import vlm.services.AccountService;
import vlm.services.ParameterService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

import static vlm.http.common.Parameters.ACCOUNT_PARAMETER;
import static vlm.http.common.ResultFields.ATS_RESPONSE;

public final class GetAccountATs extends APIServlet.APIRequestHandler {

    private final ParameterService parameterService;
    private final ATService atService;
    private final AccountService accountService;

    GetAccountATs(ParameterService parameterService, ATService atService, AccountService accountService) {
        super(new APITag[]{APITag.AT, APITag.ACCOUNTS}, ACCOUNT_PARAMETER);
        this.parameterService = parameterService;
        this.atService = atService;
        this.accountService = accountService;
    }

    @Override
    JsonElement processRequest(HttpServletRequest req) throws VolumeException {
        Account account = parameterService.getAccount(req);

        List<Long> atIds = atService.getATsIssuedBy(account.getId());
        JsonArray ats = new JsonArray();
        for (long atId : atIds) {
            ats.add(JSONData.at(atService.getAT(atId), accountService));
        }

        JsonObject response = new JsonObject();
        response.add(ATS_RESPONSE, ats);
        return response;
    }
}
