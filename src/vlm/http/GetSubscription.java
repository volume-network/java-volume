package vlm.http;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import vlm.Subscription;
import vlm.services.SubscriptionService;
import vlm.util.Convert;

import javax.servlet.http.HttpServletRequest;

import static vlm.http.common.Parameters.SUBSCRIPTION_PARAMETER;
import static vlm.http.common.ResultFields.ERROR_CODE_RESPONSE;
import static vlm.http.common.ResultFields.ERROR_DESCRIPTION_RESPONSE;

final class GetSubscription extends APIServlet.APIRequestHandler {

    private final SubscriptionService subscriptionService;

    GetSubscription(SubscriptionService subscriptionService) {
        super(new APITag[]{APITag.ACCOUNTS}, SUBSCRIPTION_PARAMETER);
        this.subscriptionService = subscriptionService;
    }

    @Override
    JsonElement processRequest(HttpServletRequest req) {
        long subscriptionId;
        try {
            subscriptionId = Convert.parseUnsignedLong(Convert.emptyToNull(req.getParameter(SUBSCRIPTION_PARAMETER)));
        } catch (Exception e) {
            JsonObject response = new JsonObject();
            response.addProperty(ERROR_CODE_RESPONSE, 3);
            response.addProperty(ERROR_DESCRIPTION_RESPONSE, "Invalid or not specified subscription");
            return response;
        }

        Subscription subscription = subscriptionService.getSubscription(subscriptionId);

        if (subscription == null) {
            JsonObject response = new JsonObject();
            response.addProperty(ERROR_CODE_RESPONSE, 5);
            response.addProperty(ERROR_DESCRIPTION_RESPONSE, "Subscription not found");
            return response;
        }

        return JSONData.subscription(subscription);
    }
}
