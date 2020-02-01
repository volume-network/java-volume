package vlm.http;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import vlm.Asset;
import vlm.assetexchange.AssetExchange;
import vlm.db.DbIterator;

import javax.servlet.http.HttpServletRequest;

import static vlm.http.common.Parameters.FIRST_INDEX_PARAMETER;
import static vlm.http.common.Parameters.LAST_INDEX_PARAMETER;
import static vlm.http.common.ResultFields.ASSETS_RESPONSE;

public final class GetAllAssets extends AbstractAssetsRetrieval {

    private final AssetExchange assetExchange;

    public GetAllAssets(AssetExchange assetExchange) {
        super(new APITag[]{APITag.AE}, assetExchange, FIRST_INDEX_PARAMETER, LAST_INDEX_PARAMETER);
        this.assetExchange = assetExchange;
    }

    @Override
    JsonElement processRequest(HttpServletRequest req) {
        int firstIndex = ParameterParser.getFirstIndex(req);
        int lastIndex = ParameterParser.getLastIndex(req);

        JsonObject response = new JsonObject();

        try (DbIterator<Asset> assets = assetExchange.getAllAssets(firstIndex, lastIndex)) {
            response.add(ASSETS_RESPONSE, assetsToJson(assets));
        }

        return response;
    }

}
