package vlm.http;

import com.google.gson.JsonElement;
import vlm.VolumeException;
import vlm.services.ParameterService;

import javax.servlet.http.HttpServletRequest;

import static vlm.http.common.Parameters.GOODS_PARAMETER;

public final class GetDGSGood extends APIServlet.APIRequestHandler {

    private final ParameterService parameterService;

    GetDGSGood(ParameterService parameterService) {
        super(new APITag[]{APITag.DGS}, GOODS_PARAMETER);
        this.parameterService = parameterService;
    }

    @Override
    JsonElement processRequest(HttpServletRequest req) throws VolumeException {
        return JSONData.goods(parameterService.getGoods(req));
    }

}
