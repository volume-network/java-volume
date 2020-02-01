package vlm.http;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import vlm.DigitalGoodsStore;
import vlm.VolumeException;
import vlm.db.DbIterator;
import vlm.services.DGSGoodsStoreService;

import javax.servlet.http.HttpServletRequest;

import static vlm.http.common.Parameters.*;
import static vlm.http.common.ResultFields.PURCHASES_RESPONSE;

public final class GetDGSPendingPurchases extends APIServlet.APIRequestHandler {

    private final DGSGoodsStoreService dgsGoodStoreService;

    GetDGSPendingPurchases(DGSGoodsStoreService dgsGoodStoreService) {
        super(new APITag[]{APITag.DGS}, SELLER_PARAMETER, FIRST_INDEX_PARAMETER, LAST_INDEX_PARAMETER);
        this.dgsGoodStoreService = dgsGoodStoreService;
    }

    @Override
    JsonElement processRequest(HttpServletRequest req) throws VolumeException {
        long sellerId = ParameterParser.getSellerId(req);

        if (sellerId == 0) {
            return JSONResponses.MISSING_SELLER;
        }

        int firstIndex = ParameterParser.getFirstIndex(req);
        int lastIndex = ParameterParser.getLastIndex(req);

        JsonObject response = new JsonObject();
        JsonArray purchasesJSON = new JsonArray();

        try (DbIterator<DigitalGoodsStore.Purchase> purchases = dgsGoodStoreService.getPendingSellerPurchases(sellerId, firstIndex, lastIndex)) {
            while (purchases.hasNext()) {
                purchasesJSON.add(JSONData.purchase(purchases.next()));
            }
        }

        response.add(PURCHASES_RESPONSE, purchasesJSON);
        return response;
    }

}
