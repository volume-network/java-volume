package vlm.grpc.handlers;

import vlm.Blockchain;
import vlm.Transaction;
import vlm.TransactionProcessor;
import vlm.grpc.GrpcApiHandler;
import vlm.grpc.proto.ApiException;
import vlm.grpc.proto.ProtoBuilder;
import vlm.grpc.proto.VlmApi;
import vlm.util.Convert;

public class GetTransactionHandler implements GrpcApiHandler<VlmApi.GetTransactionRequest, VlmApi.Transaction> {

    private final Blockchain blockchain;
    private final TransactionProcessor transactionProcessor;

    public GetTransactionHandler(Blockchain blockchain, TransactionProcessor transactionProcessor) {
        this.blockchain = blockchain;
        this.transactionProcessor = transactionProcessor;
    }

    public static Transaction getTransaction(Blockchain blockchain, TransactionProcessor transactionProcessor, VlmApi.GetTransactionRequest request) throws ApiException {
        long id = request.getId();
        byte[] fullHash = request.getFullHash().toByteArray();
        Transaction transaction;
        if (fullHash.length > 0) {
            transaction = blockchain.getTransactionByFullHash(Convert.toHexString(fullHash));
        } else if (id != 0) {
            transaction = blockchain.getTransaction(id);
            if (transaction == null) transaction = transactionProcessor.getUnconfirmedTransaction(id);
        } else {
            throw new ApiException("Could not find transaction");
        }
        if (transaction == null) {
            throw new ApiException("Could not find transaction");
        }
        return transaction;
    }

    @Override
    public VlmApi.Transaction handleRequest(VlmApi.GetTransactionRequest request) throws Exception {
        return ProtoBuilder.buildTransaction(blockchain, getTransaction(blockchain, transactionProcessor, request));
    }
}
