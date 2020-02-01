package vlm.peer;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import vlm.Blockchain;
import vlm.util.Convert;
import vlm.util.JSON;

import java.util.List;

final class GetNextBlockIds extends PeerServlet.PeerRequestHandler {

    private final Blockchain blockchain;

    GetNextBlockIds(Blockchain blockchain) {
        this.blockchain = blockchain;
    }


    @Override
    JsonElement processRequest(JsonObject request, Peer peer) {

        JsonObject response = new JsonObject();

        JsonArray nextBlockIds = new JsonArray();
        long blockId = Convert.parseUnsignedLong(JSON.getAsString(request.get("blockId")));
        List<Long> ids = blockchain.getBlockIdsAfter(blockId, 100);

        for (Long id : ids) {
            nextBlockIds.add(Convert.toUnsignedLong(id));
        }

        response.add("nextBlockIds", nextBlockIds);

        return response;
    }

}
