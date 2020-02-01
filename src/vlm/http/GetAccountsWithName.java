package vlm.http;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import vlm.Account;
import vlm.VolumeException;
import vlm.db.DbIterator;
import vlm.services.AccountService;
import vlm.util.Convert;

import javax.servlet.http.HttpServletRequest;

import static vlm.http.common.Parameters.ACCOUNTS_RESPONSE;
import static vlm.http.common.Parameters.NAME_PARAMETER;

public class GetAccountsWithName extends APIServlet.APIRequestHandler {

    private final AccountService accountService;

    GetAccountsWithName(AccountService accountService) {
        super(new APITag[]{APITag.ACCOUNTS}, NAME_PARAMETER);
        this.accountService = accountService;
    }

    @Override
    JsonElement processRequest(HttpServletRequest request) throws VolumeException {
        DbIterator<Account> accounts = accountService.getAccountsWithName(request.getParameter(NAME_PARAMETER));
        JsonArray accountIds = new JsonArray();

        while (accounts.hasNext()) {
            accountIds.add(Convert.toUnsignedLong(accounts.next().id));
        }

        accounts.close();

        JsonObject response = new JsonObject();
        response.add(ACCOUNTS_RESPONSE, accountIds);
        return response;
    }
}
