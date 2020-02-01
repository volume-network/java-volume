package vlm.http;

import com.google.gson.JsonElement;
import vlm.Alias;
import vlm.http.common.Parameters;
import vlm.services.AliasService;
import vlm.services.ParameterService;

import javax.servlet.http.HttpServletRequest;

public final class GetAlias extends APIServlet.APIRequestHandler {

    private final ParameterService parameterService;
    private final AliasService aliasService;

    GetAlias(ParameterService parameterService, AliasService aliasService) {
        super(new APITag[]{APITag.ALIASES}, Parameters.ALIAS_PARAMETER, Parameters.ALIAS_NAME_PARAMETER);
        this.parameterService = parameterService;
        this.aliasService = aliasService;
    }

    @Override
    JsonElement processRequest(HttpServletRequest req) throws ParameterException {
        final Alias alias = parameterService.getAlias(req);
        final Alias.Offer offer = aliasService.getOffer(alias);

        return JSONData.alias(alias, offer);
    }

}
