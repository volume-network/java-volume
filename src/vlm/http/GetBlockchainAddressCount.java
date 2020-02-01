package vlm.http;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import vlm.Blockchain;
import vlm.VolumeException;

import javax.servlet.http.HttpServletRequest;

import static vlm.http.common.ResultFields.TOTAL_RESPONSE;


public final class GetBlockchainAddressCount extends APIServlet.APIRequestHandler {

    private final Blockchain blockchain;

    GetBlockchainAddressCount(Blockchain blockchain) {
        super(new APITag[]{APITag.BLOCKS});
        this.blockchain = blockchain;
    }

    @Override
    JsonElement processRequest(HttpServletRequest req) throws VolumeException {
        JsonObject resp = new JsonObject();
        resp.addProperty(TOTAL_RESPONSE, blockchain.getBlockchainAddressCount());
        return resp;
    }

}
