package vlm.http;

import com.google.gson.JsonArray;
import vlm.Asset;
import vlm.assetexchange.AssetExchange;
import vlm.db.DbIterator;

abstract class AbstractAssetsRetrieval extends APIServlet.APIRequestHandler {

    private final AssetExchange assetExchange;

    AbstractAssetsRetrieval(APITag[] apiTags, AssetExchange assetExchange, String... parameters) {
        super(apiTags, parameters);
        this.assetExchange = assetExchange;
    }

    JsonArray assetsToJson(DbIterator<Asset> assets) {
        final JsonArray assetsJsonArray = new JsonArray();

        while (assets.hasNext()) {
            final Asset asset = assets.next();

            int tradeCount = assetExchange.getTradeCount(asset.getId());
            int transferCount = assetExchange.getTransferCount(asset.getId());
            int accountsCount = assetExchange.getAssetAccountsCount(asset.getId());

            assetsJsonArray.add(JSONData.asset(asset, tradeCount, transferCount, accountsCount));
        }

        return assetsJsonArray;
    }
}
