package vlm.http;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import vlm.Account;
import vlm.VolumeException;
import vlm.http.common.Parameters;
import vlm.services.ParameterService;
import vlm.util.Convert;
import vlm.util.JSON;

import javax.servlet.http.HttpServletRequest;

import static vlm.http.common.ResultFields.PUBLIC_KEY_RESPONSE;

public final class GetAccountPublicKey extends APIServlet.APIRequestHandler {

    private final ParameterService parameterService;

    GetAccountPublicKey(ParameterService parameterService) {
        super(new APITag[]{APITag.ACCOUNTS}, Parameters.ACCOUNT_PARAMETER);
        this.parameterService = parameterService;
    }

    @Override
    JsonElement processRequest(HttpServletRequest req) throws VolumeException {

        Account account = parameterService.getAccount(req);

        if (account.getPublicKey() != null) {
            JsonObject response = new JsonObject();
            response.addProperty(PUBLIC_KEY_RESPONSE, Convert.toHexString(account.getPublicKey()));
            return response;
        } else {
            return JSON.emptyJSON;
        }
    }

}
