package vlm.http;

import com.google.gson.JsonElement;
import vlm.VolumeException;
import vlm.http.common.Parameters;
import vlm.services.ParameterService;

import javax.servlet.http.HttpServletRequest;

public final class GetBalance extends APIServlet.APIRequestHandler {

    private final ParameterService parameterService;

    public GetBalance(ParameterService parameterService) {
        super(new APITag[]{APITag.ACCOUNTS}, Parameters.ACCOUNT_PARAMETER);
        this.parameterService = parameterService;
    }

    @Override
    JsonElement processRequest(HttpServletRequest req) throws VolumeException {
        return JSONData.accountBalance(parameterService.getAccount(req));
    }

}
