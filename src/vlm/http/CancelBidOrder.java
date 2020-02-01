package vlm.http;

import com.google.gson.JsonElement;
import vlm.*;
import vlm.assetexchange.AssetExchange;
import vlm.services.ParameterService;

import javax.servlet.http.HttpServletRequest;

import static vlm.http.common.Parameters.ORDER_PARAMETER;

public final class CancelBidOrder extends CreateTransaction {

    private final ParameterService parameterService;
    private final Blockchain blockchain;
    private final AssetExchange assetExchange;

    public CancelBidOrder(ParameterService parameterService, Blockchain blockchain, AssetExchange assetExchange, APITransactionManager apiTransactionManager) {
        super(new APITag[]{APITag.AE, APITag.CREATE_TRANSACTION}, apiTransactionManager, ORDER_PARAMETER);
        this.parameterService = parameterService;
        this.blockchain = blockchain;
        this.assetExchange = assetExchange;
    }

    @Override
    JsonElement processRequest(HttpServletRequest req) throws VolumeException {
        long orderId = ParameterParser.getOrderId(req);
        Account account = parameterService.getSenderAccount(req);
        Order.Bid orderData = assetExchange.getBidOrder(orderId);
        if (orderData == null || orderData.getAccountId() != account.getId()) {
            return JSONResponses.UNKNOWN_ORDER;
        }
        Attachment attachment = new Attachment.ColoredCoinsBidOrderCancellation(orderId, blockchain.getHeight());
        return createTransaction(req, account, attachment);
    }

}
