package vlm.http;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import vlm.Transaction;
import vlm.VolumeException;
import vlm.crypto.Crypto;
import vlm.services.ParameterService;
import vlm.services.TransactionService;
import vlm.util.Convert;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

import static vlm.http.JSONResponses.MISSING_SECRET_PHRASE;
import static vlm.http.common.Parameters.*;
import static vlm.http.common.ResultFields.FULL_HASH_RESPONSE;
import static vlm.http.common.ResultFields.*;

final class SignTransaction extends APIServlet.APIRequestHandler {

    private static final Logger logger = LoggerFactory.getLogger(SignTransaction.class);

    private final ParameterService parameterService;
    private final TransactionService transactionService;

    SignTransaction(ParameterService parameterService, TransactionService transactionService) {
        super(new APITag[]{APITag.TRANSACTIONS}, UNSIGNED_TRANSACTION_BYTES_PARAMETER, UNSIGNED_TRANSACTION_JSON_PARAMETER, SECRET_PHRASE_PARAMETER);
        this.parameterService = parameterService;
        this.transactionService = transactionService;
    }

    @Override
    JsonElement processRequest(HttpServletRequest req) throws VolumeException {

        String transactionBytes = Convert.emptyToNull(req.getParameter(UNSIGNED_TRANSACTION_BYTES_PARAMETER));
        String transactionJSON = Convert.emptyToNull(req.getParameter(UNSIGNED_TRANSACTION_JSON_PARAMETER));
        Transaction transaction = parameterService.parseTransaction(transactionBytes, transactionJSON);

        String secretPhrase = Convert.emptyToNull(req.getParameter(SECRET_PHRASE_PARAMETER));
        if (secretPhrase == null) {
            return MISSING_SECRET_PHRASE;
        }

        JsonObject response = new JsonObject();
        try {
            transactionService.validate(transaction);
            if (transaction.getSignature() != null) {
                response.addProperty(ERROR_CODE_RESPONSE, 4);
                response.addProperty(ERROR_DESCRIPTION_RESPONSE, "Incorrect unsigned transaction - already signed");
                return response;
            }
            if (!Arrays.equals(Crypto.getPublicKey(secretPhrase), transaction.getSenderPublicKey())) {
                response.addProperty(ERROR_CODE_RESPONSE, 4);
                response.addProperty(ERROR_DESCRIPTION_RESPONSE, "Secret phrase doesn't match transaction sender public key");
                return response;
            }
            transaction.sign(secretPhrase);
            response.addProperty(TRANSACTION_RESPONSE, transaction.getStringId());
            response.addProperty(FULL_HASH_RESPONSE, transaction.getFullHash());
            response.addProperty(TRANSACTION_BYTES_RESPONSE, Convert.toHexString(transaction.getBytes()));
            response.addProperty(SIGNATURE_HASH_RESPONSE, Convert.toHexString(Crypto.sha256().digest(transaction.getSignature())));
            response.addProperty(VERIFY_RESPONSE, transaction.verifySignature() && transactionService.verifyPublicKey(transaction));
        } catch (VolumeException.ValidationException | RuntimeException e) {
            logger.debug(e.getMessage(), e);
            response.addProperty(ERROR_CODE_RESPONSE, 4);
            response.addProperty(ERROR_DESCRIPTION_RESPONSE, "Incorrect unsigned transaction: " + e.toString());
            response.addProperty(ERROR_RESPONSE, e.getMessage());
            return response;
        }
        return response;
    }

}
