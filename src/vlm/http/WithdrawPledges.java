package vlm.http;

import com.google.gson.JsonElement;
import vlm.*;
import vlm.services.AccountService;
import vlm.services.ParameterService;
import vlm.services.TimeService;
import vlm.util.Convert;

import javax.servlet.http.HttpServletRequest;

import static vlm.http.JSONResponses.*;
import static vlm.http.common.Parameters.AMOUNT_NQT_PARAMETER;

public final class WithdrawPledges extends CreateTransaction {

    private final ParameterService parameterService;
    private final Blockchain blockchain;
    private final AccountService accountService;
    private final TimeService timeService;

    public WithdrawPledges(ParameterService parameterService, Blockchain blockchain, AccountService accountService, TimeService timeService, APITransactionManager apiTransactionManager) {
        super(new APITag[]{APITag.ACCOUNTS, APITag.MINING, APITag.CREATE_TRANSACTION}, apiTransactionManager, AMOUNT_NQT_PARAMETER);
        this.parameterService = parameterService;
        this.blockchain = blockchain;
        this.accountService = accountService;
        this.timeService = timeService;
    }

    @Override
    JsonElement processRequest(HttpServletRequest req) throws VolumeException {
        String amountValueNQT = Convert.emptyToNull(req.getParameter(AMOUNT_NQT_PARAMETER));
        if (amountValueNQT == null) {
            return MISSING_AMOUNT;
        }
        long amountNQT;
        try {
            amountNQT = Long.parseLong(amountValueNQT);
        } catch (RuntimeException e) {
            return INCORRECT_AMOUNT;
        }
        if (amountNQT <= 0 || amountNQT >= Constants.MAX_BALANCE_NQT) {
//			throw new ParameterException(INCORRECT_PRICE);
            return INCORRECT_AMOUNT;
        }
        final Account account = parameterService.getSenderAccount(req);
        Account.Pledges unpledgeAccount = accountService.getAccountPledge(account.getId());
        if (unpledgeAccount == null || amountNQT > unpledgeAccount.getUnpledgeTotal()) {
            return NOT_ENOUGH_UNPLEDGE;
        }

        Attachment attachment = new Attachment.WithdrawPledgeAssignment(amountNQT, timeService.getEpochTimeMillis(), blockchain.getHeight());
        return createTransaction(req, account, null, amountNQT, attachment);
    }

}
