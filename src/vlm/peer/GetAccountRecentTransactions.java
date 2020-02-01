package vlm.peer;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import vlm.Account;
import vlm.Blockchain;
import vlm.Transaction;
import vlm.db.DbIterator;
import vlm.http.JSONData;
import vlm.services.AccountService;
import vlm.util.Convert;
import vlm.util.JSON;

public class GetAccountRecentTransactions extends PeerServlet.PeerRequestHandler {

    private final AccountService accountService;
    private final Blockchain blockchain;

    GetAccountRecentTransactions(AccountService accountService, Blockchain blockchain) {
        this.accountService = accountService;
        this.blockchain = blockchain;
    }

    @Override
    JsonElement processRequest(JsonObject request, Peer peer) {

        JsonObject response = new JsonObject();

        try {
            Long accountId = Convert.parseAccountId(JSON.getAsString(request.get("account")));
            Account account = accountService.getAccount(accountId);
            JsonArray transactions = new JsonArray();
            if (account != null) {
                DbIterator<? extends Transaction> iterator = blockchain.getTransactions(account, 0, (byte) -1, (byte) 0, 0, 0, 9);
                while (iterator.hasNext()) {
                    Transaction transaction = iterator.next();
                    transactions.add(JSONData.transaction(transaction, blockchain.getHeight()));
                }
            }
            response.add("transactions", transactions);
        } catch (Exception e) {
        }

        return response;
    }

}
