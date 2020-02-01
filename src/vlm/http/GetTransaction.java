package vlm.http;

import com.google.gson.JsonElement;
import vlm.Blockchain;
import vlm.Transaction;
import vlm.TransactionProcessor;
import vlm.util.Convert;

import javax.servlet.http.HttpServletRequest;

import static vlm.http.common.Parameters.FULL_HASH_PARAMETER;
import static vlm.http.common.Parameters.TRANSACTION_PARAMETER;

final class GetTransaction extends APIServlet.APIRequestHandler {

    private final TransactionProcessor transactionProcessor;
    private final Blockchain blockchain;

    GetTransaction(TransactionProcessor transactionProcessor, Blockchain blockchain) {
        super(new APITag[]{APITag.TRANSACTIONS}, TRANSACTION_PARAMETER, FULL_HASH_PARAMETER);
        this.transactionProcessor = transactionProcessor;
        this.blockchain = blockchain;
    }

    @Override
    JsonElement processRequest(HttpServletRequest req) {

        String transactionIdString = Convert.emptyToNull(req.getParameter(TRANSACTION_PARAMETER));
        String transactionFullHash = Convert.emptyToNull(req.getParameter(FULL_HASH_PARAMETER));
        if (transactionIdString == null && transactionFullHash == null) {
            return JSONResponses.MISSING_TRANSACTION;
        }

        long transactionId = 0;
        Transaction transaction;
        try {
            if (transactionIdString != null) {
                transactionId = Convert.parseUnsignedLong(transactionIdString);
                transaction = blockchain.getTransaction(transactionId);
            } else {
                transaction = blockchain.getTransactionByFullHash(transactionFullHash);
                if (transaction == null) {
                    return JSONResponses.UNKNOWN_TRANSACTION;
                }
            }
        } catch (RuntimeException e) {
            return JSONResponses.INCORRECT_TRANSACTION;
        }

        if (transaction == null) {
            transaction = transactionProcessor.getUnconfirmedTransaction(transactionId);
            if (transaction == null) {
                return JSONResponses.UNKNOWN_TRANSACTION;
            }
            return JSONData.unconfirmedTransaction(transaction);
        } else {
            return JSONData.transaction(transaction, blockchain.getHeight());
        }

    }

}
