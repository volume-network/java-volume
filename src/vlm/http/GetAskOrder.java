package vlm.http;

import com.google.gson.JsonElement;
import vlm.Order;
import vlm.VolumeException;
import vlm.assetexchange.AssetExchange;

import javax.servlet.http.HttpServletRequest;

import static vlm.http.common.Parameters.ORDER_PARAMETER;

public final class GetAskOrder extends APIServlet.APIRequestHandler {

    private final AssetExchange assetExchange;

    GetAskOrder(AssetExchange assetExchange) {
        super(new APITag[]{APITag.AE}, ORDER_PARAMETER);
        this.assetExchange = assetExchange;
    }

    @Override
    JsonElement processRequest(HttpServletRequest req) throws VolumeException {
        long orderId = ParameterParser.getOrderId(req);
        Order.Ask askOrder = assetExchange.getAskOrder(orderId);
        if (askOrder == null) {
            return JSONResponses.UNKNOWN_ORDER;
        }
        return JSONData.askOrder(askOrder);
    }

}
