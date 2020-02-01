package vlm.peer;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import vlm.Transaction;
import vlm.TransactionProcessor;
import vlm.http.common.ResultFields;
import vlm.peer.PeerServlet.ExtendedProcessRequest;

import java.util.List;

final class GetUnconfirmedTransactions extends PeerServlet.ExtendedPeerRequestHandler {

    private final TransactionProcessor transactionProcessor;

    private final Logger logger = LoggerFactory.getLogger(GetUnconfirmedTransactions.class);

    GetUnconfirmedTransactions(TransactionProcessor transactionProcessor) {
        this.transactionProcessor = transactionProcessor;
    }

    @Override
    ExtendedProcessRequest extendedProcessRequest(JsonObject request, Peer peer) {
        JsonObject response = new JsonObject();

        final List<Transaction> unconfirmedTransactions = transactionProcessor.getAllUnconfirmedTransactionsFor(peer);

        JsonArray transactionsData = new JsonArray();
        for (Transaction transaction : unconfirmedTransactions) {
            transactionsData.add(transaction.getJsonObject());
        }

        response.add(ResultFields.UNCONFIRMED_TRANSACTIONS_RESPONSE, transactionsData);

        return new ExtendedProcessRequest(response, () -> transactionProcessor.markFingerPrintsOf(peer, unconfirmedTransactions));
    }

}
