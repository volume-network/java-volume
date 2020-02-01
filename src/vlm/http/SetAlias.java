package vlm.http;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import vlm.*;
import vlm.services.AliasService;
import vlm.services.ParameterService;
import vlm.util.Convert;
import vlm.util.TextUtils;

import javax.servlet.http.HttpServletRequest;

import static vlm.http.common.Parameters.ALIAS_NAME_PARAMETER;
import static vlm.http.common.Parameters.ALIAS_URI_PARAMETER;
import static vlm.http.common.ResultFields.ERROR_CODE_RESPONSE;
import static vlm.http.common.ResultFields.ERROR_DESCRIPTION_RESPONSE;

public final class SetAlias extends CreateTransaction {

    private final ParameterService parameterService;
    private final Blockchain blockchain;
    private final AliasService aliasService;

    public SetAlias(ParameterService parameterService, Blockchain blockchain, AliasService aliasService, APITransactionManager apiTransactionManager) {
        super(new APITag[]{APITag.ALIASES, APITag.CREATE_TRANSACTION}, apiTransactionManager, ALIAS_NAME_PARAMETER, ALIAS_URI_PARAMETER);
        this.parameterService = parameterService;
        this.blockchain = blockchain;
        this.aliasService = aliasService;
    }

    @Override
    JsonElement processRequest(HttpServletRequest req) throws VolumeException {
        String aliasName = Convert.emptyToNull(req.getParameter(ALIAS_NAME_PARAMETER));
        String aliasURI = Convert.nullToEmpty(req.getParameter(ALIAS_URI_PARAMETER));

        if (aliasName == null) {
            return JSONResponses.MISSING_ALIAS_NAME;
        }

        aliasName = aliasName.trim();
        if (aliasName.isEmpty() || aliasName.length() > Constants.MAX_ALIAS_LENGTH) {
            return JSONResponses.INCORRECT_ALIAS_LENGTH;
        }

        if (!TextUtils.isInAlphabet(aliasName)) {
            return JSONResponses.INCORRECT_ALIAS_NAME;
        }

        aliasURI = aliasURI.trim();
        if (aliasURI.length() > Constants.MAX_ALIAS_URI_LENGTH) {
            return JSONResponses.INCORRECT_URI_LENGTH;
        }

        Account account = parameterService.getSenderAccount(req);

        Alias alias = aliasService.getAlias(aliasName);
        if (alias != null && alias.getAccountId() != account.getId()) {
            JsonObject response = new JsonObject();
            response.addProperty(ERROR_CODE_RESPONSE, 8);
            response.addProperty(ERROR_DESCRIPTION_RESPONSE, "\"" + aliasName + "\" is already used");
            return response;
        }

        Attachment attachment = new Attachment.MessagingAliasAssignment(aliasName, aliasURI, blockchain.getHeight());
        return createTransaction(req, account, attachment);

    }

}
