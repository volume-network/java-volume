package vlm.http;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import vlm.Account;
import vlm.VolumeException;
import vlm.db.DbIterator;
import vlm.services.AccountService;
import vlm.services.ParameterService;
import vlm.util.Convert;

import javax.servlet.http.HttpServletRequest;

import static vlm.http.common.Parameters.ACCOUNTS_RESPONSE;
import static vlm.http.common.Parameters.ACCOUNT_PARAMETER;

public final class GetAccountsWithRewardRecipient extends APIServlet.APIRequestHandler {

    private final ParameterService parameterService;
    private final AccountService accountService;

    GetAccountsWithRewardRecipient(ParameterService parameterService, AccountService accountService) {
        super(new APITag[]{APITag.ACCOUNTS, APITag.MINING, APITag.INFO}, ACCOUNT_PARAMETER);
        this.parameterService = parameterService;
        this.accountService = accountService;
    }

    @Override
    JsonElement processRequest(HttpServletRequest req) throws VolumeException {
        JsonObject response = new JsonObject();

        Account targetAccount = parameterService.getAccount(req);

        JsonArray accounts = new JsonArray();

        DbIterator<Account.RewardRecipientAssignment> assignments = accountService.getAccountsWithRewardRecipient(targetAccount.getId());
        while (assignments.hasNext()) {
            Account.RewardRecipientAssignment assignment = assignments.next();
            accounts.add(Convert.toUnsignedLong(assignment.getAccountId()));
        }
        if (accountService.getRewardRecipientAssignment(targetAccount) == null) {
            accounts.add(Convert.toUnsignedLong(targetAccount.getId()));
        }

        response.add(ACCOUNTS_RESPONSE, accounts);

        return response;
    }
}
