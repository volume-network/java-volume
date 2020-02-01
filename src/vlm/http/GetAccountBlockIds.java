package vlm.http;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import vlm.Account;
import vlm.Block;
import vlm.Blockchain;
import vlm.VolumeException;
import vlm.db.DbIterator;
import vlm.services.ParameterService;

import javax.servlet.http.HttpServletRequest;

import static vlm.http.common.Parameters.*;
import static vlm.http.common.ResultFields.BLOCK_IDS_RESPONSE;

public final class GetAccountBlockIds extends APIServlet.APIRequestHandler {

    private final ParameterService parameterService;
    private final Blockchain blockchain;

    GetAccountBlockIds(ParameterService parameterService, Blockchain blockchain) {
        super(new APITag[]{APITag.ACCOUNTS}, ACCOUNT_PARAMETER, TIMESTAMP_PARAMETER, FIRST_INDEX_PARAMETER, LAST_INDEX_PARAMETER);
        this.parameterService = parameterService;
        this.blockchain = blockchain;
    }

    @Override
    JsonElement processRequest(HttpServletRequest req) throws VolumeException {
        Account account = parameterService.getAccount(req);

        int timestamp = ParameterParser.getTimestamp(req);
        int firstIndex = ParameterParser.getFirstIndex(req);
        int lastIndex = ParameterParser.getLastIndex(req);

        JsonArray blockIds = new JsonArray();
        try (DbIterator<? extends Block> iterator = blockchain.getBlocks(account, timestamp, firstIndex, lastIndex)) {
            while (iterator.hasNext()) {
                Block block = iterator.next();
                blockIds.add(block.getStringId());
            }
        }

        JsonObject response = new JsonObject();
        response.add(BLOCK_IDS_RESPONSE, blockIds);

        return response;
    }

}
