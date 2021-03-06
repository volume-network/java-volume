package vlm.http;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import vlm.Account;
import vlm.Blockchain;
import vlm.VolumeException;
import vlm.services.ParameterService;

import javax.servlet.http.HttpServletRequest;

import static vlm.http.common.Parameters.ACCOUNT_PARAMETER;
import static vlm.http.common.Parameters.HEIGHT_PARAMETER;
import static vlm.http.common.ResultFields.*;

public final class GetAccountLessors extends APIServlet.APIRequestHandler {

    private final ParameterService parameterService;
    private final Blockchain blockchain;

    GetAccountLessors(ParameterService parameterService, Blockchain blockchain) {
        super(new APITag[]{APITag.ACCOUNTS}, ACCOUNT_PARAMETER, HEIGHT_PARAMETER);
        this.parameterService = parameterService;
        this.blockchain = blockchain;
    }

    @Override
    JsonElement processRequest(HttpServletRequest req) throws VolumeException {

        Account account = parameterService.getAccount(req);
        int height = parameterService.getHeight(req);
        if (height < 0) {
            height = blockchain.getHeight();
        }

        JsonObject response = new JsonObject();
        JSONData.putAccount(response, ACCOUNT_RESPONSE, account.getId());
        response.addProperty(HEIGHT_RESPONSE, height);
        JsonArray lessorsJSON = new JsonArray();

    /*try (DbIterator<Account> lessors = account.getLessors(height)) {
      if (lessors.hasNext()) {
      while (lessors.hasNext()) {
      Account lessor = lessors.next();
      JsonObject lessorJSON = new JsonObject();
      JSONData.putAccount(lessorJSON, "lessor", lessor.getId());
      lessorJSON.put("guaranteedBalanceNQT", String.valueOf(account.getGuaranteedBalanceNQT(1440, height)));
      lessorsJSON.add(lessorJSON);
      }
      }
      }*/
        response.add(LESSORS_RESPONSE, lessorsJSON);
        return response;

    }

}
