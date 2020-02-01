package vlm.http;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import vlm.Account;
import vlm.Subscription;
import vlm.VolumeException;
import vlm.db.DbIterator;
import vlm.services.ParameterService;
import vlm.services.SubscriptionService;

import javax.servlet.http.HttpServletRequest;

import static vlm.http.common.Parameters.ACCOUNT_PARAMETER;

final class GetSubscriptionsToAccount extends APIServlet.APIRequestHandler {

    private final ParameterService parameterService;
    private final SubscriptionService subscriptionService;

    GetSubscriptionsToAccount(ParameterService parameterService, SubscriptionService subscriptionService) {
        super(new APITag[]{APITag.ACCOUNTS}, ACCOUNT_PARAMETER);
        this.parameterService = parameterService;
        this.subscriptionService = subscriptionService;
    }

    @Override
    JsonElement processRequest(HttpServletRequest req) throws VolumeException {
        final Account account = parameterService.getAccount(req);

        JsonObject response = new JsonObject();

        JsonArray subscriptions = new JsonArray();

        DbIterator<Subscription> accountSubscriptions = subscriptionService.getSubscriptionsToId(account.getId());

        while (accountSubscriptions.hasNext()) {
            subscriptions.add(JSONData.subscription(accountSubscriptions.next()));
        }

        response.add("subscriptions", subscriptions);
        return response;
    }
}
