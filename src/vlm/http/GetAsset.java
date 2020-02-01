package vlm.http;

import com.google.gson.JsonElement;
import vlm.Asset;
import vlm.VolumeException;
import vlm.assetexchange.AssetExchange;
import vlm.services.ParameterService;

import javax.servlet.http.HttpServletRequest;

import static vlm.http.common.Parameters.ASSET_PARAMETER;

public final class GetAsset extends APIServlet.APIRequestHandler {

    private final ParameterService parameterService;
    private final AssetExchange assetExchange;

    GetAsset(ParameterService parameterService, AssetExchange assetExchange) {
        super(new APITag[]{APITag.AE}, ASSET_PARAMETER);
        this.parameterService = parameterService;
        this.assetExchange = assetExchange;
    }

    @Override
    JsonElement processRequest(HttpServletRequest req) throws VolumeException {
        final Asset asset = parameterService.getAsset(req);

        int tradeCount = assetExchange.getTradeCount(asset.getId());
        int transferCount = assetExchange.getTransferCount(asset.getId());
        int accountsCount = assetExchange.getAssetAccountsCount(asset.getId());

        return JSONData.asset(asset, tradeCount, transferCount, accountsCount);
    }

}
