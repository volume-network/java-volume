package vlm.http;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import vlm.Account;
import vlm.Asset;
import vlm.AssetTransfer;
import vlm.VolumeException;
import vlm.assetexchange.AssetExchange;
import vlm.db.DbIterator;
import vlm.db.sql.DbUtils;
import vlm.http.common.Parameters;
import vlm.services.AccountService;
import vlm.services.ParameterService;
import vlm.util.Convert;

import javax.servlet.http.HttpServletRequest;

import static vlm.http.common.Parameters.*;
import static vlm.http.common.ResultFields.TRANSFERS_RESPONSE;

public final class GetAssetTransfers extends APIServlet.APIRequestHandler {

    private final ParameterService parameterService;
    private final AccountService accountService;
    private final AssetExchange assetExchange;

    GetAssetTransfers(ParameterService parameterService, AccountService accountService, AssetExchange assetExchange) {
        super(new APITag[]{APITag.AE}, ASSET_PARAMETER, ACCOUNT_PARAMETER, FIRST_INDEX_PARAMETER, LAST_INDEX_PARAMETER, INCLUDE_ASSET_INFO_PARAMETER);
        this.parameterService = parameterService;
        this.accountService = accountService;
        this.assetExchange = assetExchange;
    }

    @Override
    JsonElement processRequest(HttpServletRequest req) throws VolumeException {

        String assetId = Convert.emptyToNull(req.getParameter(ASSET_PARAMETER));
        String accountId = Convert.emptyToNull(req.getParameter(ACCOUNT_PARAMETER));

        int firstIndex = ParameterParser.getFirstIndex(req);
        int lastIndex = ParameterParser.getLastIndex(req);
        boolean includeAssetInfo = !Parameters.isFalse(req.getParameter(INCLUDE_ASSET_INFO_PARAMETER));

        JsonObject response = new JsonObject();
        JsonArray transfersData = new JsonArray();
        DbIterator<AssetTransfer> transfers = null;
        try {
            if (accountId == null) {
                Asset asset = parameterService.getAsset(req);
                transfers = assetExchange.getAssetTransfers(asset.getId(), firstIndex, lastIndex);
            } else if (assetId == null) {
                Account account = parameterService.getAccount(req);
                transfers = accountService.getAssetTransfers(account.getId(), firstIndex, lastIndex);
            } else {
                Asset asset = parameterService.getAsset(req);
                Account account = parameterService.getAccount(req);
                transfers = assetExchange.getAccountAssetTransfers(account.getId(), asset.getId(), firstIndex, lastIndex);
            }
            while (transfers.hasNext()) {
                final AssetTransfer transfer = transfers.next();
                final Asset asset = includeAssetInfo ? assetExchange.getAsset(transfer.getAssetId()) : null;

                transfersData.add(JSONData.assetTransfer(transfer, asset));
            }
        } finally {
            DbUtils.close(transfers);
        }

        response.add(TRANSFERS_RESPONSE, transfersData);

        return response;
    }

    @Override
    boolean startDbTransaction() {
        return true;
    }
}
