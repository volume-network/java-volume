package vlm.http;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import vlm.Order;
import vlm.VolumeException;
import vlm.assetexchange.AssetExchange;
import vlm.db.DbIterator;
import vlm.services.ParameterService;

import javax.servlet.http.HttpServletRequest;

import static vlm.http.common.Parameters.*;
import static vlm.http.common.ResultFields.ASK_ORDERS_RESPONSE;

public final class GetAskOrders extends APIServlet.APIRequestHandler {

    private final ParameterService parameterService;
    private final AssetExchange assetExchange;

    GetAskOrders(ParameterService parameterService, AssetExchange assetExchange) {
        super(new APITag[]{APITag.AE}, ASSET_PARAMETER, FIRST_INDEX_PARAMETER, LAST_INDEX_PARAMETER);
        this.parameterService = parameterService;
        this.assetExchange = assetExchange;
    }

    @Override
    JsonElement processRequest(HttpServletRequest req) throws VolumeException {

        long assetId = parameterService.getAsset(req).getId();
        int firstIndex = ParameterParser.getFirstIndex(req);
        int lastIndex = ParameterParser.getLastIndex(req);

        JsonArray orders = new JsonArray();
        try (DbIterator<Order.Ask> askOrders = assetExchange.getSortedAskOrders(assetId, firstIndex, lastIndex)) {
            while (askOrders.hasNext()) {
                orders.add(JSONData.askOrder(askOrders.next()));
            }
        }

        JsonObject response = new JsonObject();
        response.add(ASK_ORDERS_RESPONSE, orders);
        return response;

    }

}
