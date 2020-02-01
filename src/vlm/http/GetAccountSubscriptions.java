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
import static vlm.http.common.Parameters.SUBSCRIPTIONS_RESPONSE;

public final class GetAccountSubscriptions extends APIServlet.APIRequestHandler {

    private final ParameterService parameterService;
    private final SubscriptionService subscriptionService;

    GetAccountSubscriptions(ParameterService parameterService, SubscriptionService subscriptionService) {
        super(new APITag[]{APITag.ACCOUNTS}, ACCOUNT_PARAMETER);
        this.parameterService = parameterService;
        this.subscriptionService = subscriptionService;
    }

    @Override
    JsonElement processRequest(HttpServletRequest req) throws VolumeException {

        Account account = parameterService.getAccount(req);

        JsonObject response = new JsonObject();

        JsonArray subscriptions = new JsonArray();

        DbIterator<Subscription> accountSubscriptions = subscriptionService.getSubscriptionsByParticipant(account.getId());

        while (accountSubscriptions.hasNext()) {
            subscriptions.add(JSONData.subscription(accountSubscriptions.next()));
        }

        response.add(SUBSCRIPTIONS_RESPONSE, subscriptions);
        return response;
    }
}
