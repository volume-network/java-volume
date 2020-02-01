package vlm.http;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import vlm.BlockchainProcessor;

import javax.servlet.http.HttpServletRequest;

import static vlm.http.common.ResultFields.DONE_RESPONSE;
import static vlm.http.common.ResultFields.ERROR_RESPONSE;

public final class FullReset extends APIServlet.APIRequestHandler {

    private final BlockchainProcessor blockchainProcessor;

    FullReset(BlockchainProcessor blockchainProcessor) {
        super(new APITag[]{APITag.DEBUG});
        this.blockchainProcessor = blockchainProcessor;
    }

    @Override
    JsonElement processRequest(HttpServletRequest req) {
        JsonObject response = new JsonObject();
        try {
            blockchainProcessor.fullReset();
            response.addProperty(DONE_RESPONSE, true);
        } catch (RuntimeException e) {
            response.addProperty(ERROR_RESPONSE, e.toString());
        }
        return response;
    }

    @Override
    final boolean requirePost() {
        return true;
    }

}
