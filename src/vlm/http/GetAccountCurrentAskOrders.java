package vlm.http;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import vlm.Order;
import vlm.VolumeException;
import vlm.assetexchange.AssetExchange;
import vlm.db.DbIterator;
import vlm.services.ParameterService;
import vlm.util.Convert;

import javax.servlet.http.HttpServletRequest;

import static vlm.http.common.Parameters.*;
import static vlm.http.common.ResultFields.ASK_ORDERS_RESPONSE;

public final class GetAccountCurrentAskOrders extends APIServlet.APIRequestHandler {

    private final ParameterService parameterService;
    private final AssetExchange assetExchange;

    GetAccountCurrentAskOrders(ParameterService parameterService, AssetExchange assetExchange) {
        super(new APITag[]{APITag.ACCOUNTS, APITag.AE}, ACCOUNT_PARAMETER, ASSET_PARAMETER, FIRST_INDEX_PARAMETER, LAST_INDEX_PARAMETER);
        this.parameterService = parameterService;
        this.assetExchange = assetExchange;
    }

    @Override
    JsonElement processRequest(HttpServletRequest req) throws VolumeException {
        final long accountId = parameterService.getAccount(req).getId();

        long assetId = 0;
        try {
            assetId = Convert.parseUnsignedLong(req.getParameter(ASSET_PARAMETER));
        } catch (RuntimeException e) {
            // ignore
        }
        int firstIndex = ParameterParser.getFirstIndex(req);
        int lastIndex = ParameterParser.getLastIndex(req);

        DbIterator<Order.Ask> askOrders;
        if (assetId == 0) {
            askOrders = assetExchange.getAskOrdersByAccount(accountId, firstIndex, lastIndex);
        } else {
            askOrders = assetExchange.getAskOrdersByAccountAsset(accountId, assetId, firstIndex, lastIndex);
        }
        JsonArray orders = new JsonArray();
        try {
            while (askOrders.hasNext()) {
                orders.add(JSONData.askOrder(askOrders.next()));
            }
        } finally {
            askOrders.close();
        }
        JsonObject response = new JsonObject();
        response.add(ASK_ORDERS_RESPONSE, orders);
        return response;
    }

}
