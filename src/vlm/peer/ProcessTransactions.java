package vlm.peer;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import vlm.TransactionProcessor;
import vlm.VolumeException;
import vlm.util.JSON;

final class ProcessTransactions extends PeerServlet.PeerRequestHandler {

    private final TransactionProcessor transactionProcessor;

    ProcessTransactions(TransactionProcessor transactionProcessor) {
        this.transactionProcessor = transactionProcessor;
    }


    @Override
    JsonElement processRequest(JsonObject request, Peer peer) {

        try {
            transactionProcessor.processPeerTransactions(request, peer);
            return JSON.emptyJSON;
        } catch (RuntimeException | VolumeException.ValidationException e) {
            //logger.debug("Failed to parse peer transactions: " + request.toJSONString());
            peer.blacklist(e, "received invalid data via requestType=processTransactions");
            JsonObject response = new JsonObject();
            response.addProperty("error", e.toString());
            return response;
        }
    }
}
