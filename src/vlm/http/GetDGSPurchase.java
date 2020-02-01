package vlm.http;

import com.google.gson.JsonElement;
import vlm.VolumeException;
import vlm.services.ParameterService;

import javax.servlet.http.HttpServletRequest;

import static vlm.http.common.Parameters.PURCHASE_PARAMETER;

public final class GetDGSPurchase extends APIServlet.APIRequestHandler {

    private final ParameterService parameterService;

    public GetDGSPurchase(ParameterService parameterService) {
        super(new APITag[]{APITag.DGS}, PURCHASE_PARAMETER);
        this.parameterService = parameterService;
    }

    @Override
    JsonElement processRequest(HttpServletRequest req) throws VolumeException {
        return JSONData.purchase(parameterService.getPurchase(req));
    }

}
