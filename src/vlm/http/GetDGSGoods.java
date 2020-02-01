package vlm.http;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import vlm.DigitalGoodsStore;
import vlm.VolumeException;
import vlm.db.DbIterator;
import vlm.db.sql.DbUtils;
import vlm.http.common.Parameters;
import vlm.services.DGSGoodsStoreService;

import javax.servlet.http.HttpServletRequest;

import static vlm.http.common.Parameters.*;
import static vlm.http.common.ResultFields.GOODS_RESPONSE;

public final class GetDGSGoods extends APIServlet.APIRequestHandler {

    private final DGSGoodsStoreService digitalGoodsStoreService;

    public GetDGSGoods(DGSGoodsStoreService digitalGoodsStoreService) {
        super(new APITag[]{APITag.DGS}, SELLER_PARAMETER, FIRST_INDEX_PARAMETER, LAST_INDEX_PARAMETER, IN_STOCK_ONLY_PARAMETER);
        this.digitalGoodsStoreService = digitalGoodsStoreService;
    }

    @Override
    JsonElement processRequest(HttpServletRequest req) throws VolumeException {
        long sellerId = ParameterParser.getSellerId(req);
        int firstIndex = ParameterParser.getFirstIndex(req);
        int lastIndex = ParameterParser.getLastIndex(req);
        boolean inStockOnly = !Parameters.isFalse(req.getParameter(IN_STOCK_ONLY_PARAMETER));

        JsonObject response = new JsonObject();
        JsonArray goodsJSON = new JsonArray();
        response.add(GOODS_RESPONSE, goodsJSON);

        DbIterator<DigitalGoodsStore.Goods> goods = null;
        try {
            if (sellerId == 0) {
                if (inStockOnly) {
                    goods = digitalGoodsStoreService.getGoodsInStock(firstIndex, lastIndex);
                } else {
                    goods = digitalGoodsStoreService.getAllGoods(firstIndex, lastIndex);
                }
            } else {
                goods = digitalGoodsStoreService.getSellerGoods(sellerId, inStockOnly, firstIndex, lastIndex);
            }
            while (goods.hasNext()) {
                DigitalGoodsStore.Goods good = goods.next();
                goodsJSON.add(JSONData.goods(good));
            }
        } finally {
            DbUtils.close(goods);
        }

        return response;
    }

}
