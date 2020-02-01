package vlm.unconfirmedtransactions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import vlm.Account;
import vlm.Transaction;
import vlm.TransactionType;
import vlm.VolumeException;
import vlm.db.store.AccountStore;
import vlm.db.store.PledgeStore;
import vlm.util.Convert;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class ReservedBalanceCache {

    private static final Logger LOGGER = LoggerFactory.getLogger(ReservedBalanceCache.class);

    private final AccountStore accountStore;
    private final PledgeStore pledgeStore;

    private final HashMap<Long, Long> reservedBalanceCache;
    private final HashMap<Long, Long> reservedPledgeCache;
    private final HashMap<Long, Long> reservedUnpledgeCache;
    private final HashMap<Long, Long> reservedWithdrawCache;
    private final HashMap<Long, Long> reservedPledgeAccountCache;

    public ReservedBalanceCache(AccountStore accountStore, PledgeStore pledgeStore) {
        this.accountStore = accountStore;
        this.pledgeStore = pledgeStore;

        this.reservedBalanceCache = new HashMap<>();
        this.reservedPledgeCache = new HashMap<>();// account - > pledgeTotal
        this.reservedUnpledgeCache = new HashMap<>();// account - > // unpledgeTotal
        this.reservedWithdrawCache = new HashMap<>();// account - > // withdrawTotal
        this.reservedPledgeAccountCache = new HashMap<>(); //pledge account -> pool account
    }

    void reserveBalanceAndPut(Transaction transaction) throws VolumeException.ValidationException {
        Account senderAccount = null;
        Account.Pledges pledgeAccount = null;

        if (transaction.getSenderId() != 0) {
            senderAccount = accountStore.getAccountTable()
                    .get(accountStore.getAccountKeyFactory().newKey(transaction.getSenderId()));
            pledgeAccount = pledgeStore.getPledgesTable().get(pledgeStore.getPledgeKeyFactory().newKey(transaction.getSenderId()));
            //System.out.printf("pledge account:%s,pledgeTotal:%s,unpledgeTotal:%s", pledgeAccount.getAccountID(),pledgeAccount.getPledgeTotal(),pledgeAccount.getUnpledgeTotal());
        }
//		System.out.printf("getType():%s, getsubtyepe():%s", transaction.getType().getType(),transaction.getType().getSubtype());
//		System.out.printf("type():%s, subtyepe():%s", TransactionType.Payment.PAYMENT_TRANSACTIONS_PLEDGE.getType(),TransactionType.Payment.PAYMENT_TRANSACTIONS_PLEDGE.getSubtype());
        if (transaction.getType().getType() == TransactionType.Payment.PAYMENT_TRANSACTIONS_PLEDGE.getType() && transaction.getType().getSubtype() == TransactionType.Payment.PAYMENT_TRANSACTIONS_PLEDGE.getSubtype()) {
            Long recepientCache = reservedPledgeAccountCache.getOrDefault(transaction.getSenderId(), 0L);
            if (recepientCache != 0 && transaction.getRecipientId() != recepientCache) {
                LOGGER.info(String.format("DO NOT pledge more than one pool Account at same time. Transaction %s, sender: %s: want to pledge to: %s, but already pledge to : %s, ",
                        transaction.getId(), transaction.getSenderId(), transaction.getRecipientId(), recepientCache));

                throw new VolumeException.NotCurrentlyValidException("DO NOT pledge more than one pool Account at same time.");
            }
            reservedPledgeAccountCache.put(transaction.getSenderId(), transaction.getRecipientId());
            verifyBalanceAndPut(transaction, senderAccount, reservedBalanceCache, reservedPledgeCache);
        } else if (transaction.getType().getType() == TransactionType.Payment.PAYMENT_TRANSACTIONS_UNPLEDGE.getType() && transaction.getType().getSubtype() == TransactionType.Payment.PAYMENT_TRANSACTIONS_UNPLEDGE.getSubtype()) {
            if (pledgeAccount == null) {
                LOGGER.info(String.format(
                        "Transaction %d: Account %d has no pledge balance",
                        transaction.getId(), transaction.getSenderId()));

                throw new VolumeException.NotCurrentlyValidException("Pledge Account unknown");
            }
            this.reservedPledgeAccountCache.remove(transaction.getSenderId());
            verifyPledgeAndPut(transaction, senderAccount, pledgeAccount.getPledgeTotal(), reservedUnpledgeCache);
        } else if (transaction.getType().getType() == TransactionType.Payment.PAYMENT_TRANSACTIONS_WITHDRAW.getType() && transaction.getType().getSubtype() == TransactionType.Payment.PAYMENT_TRANSACTIONS_WITHDRAW.getSubtype()) {
            if (pledgeAccount == null) {
                LOGGER.info(String.format(
                        "Transaction %d: Account %d has no pledge balance",
                        transaction.getId(), transaction.getSenderId()));

                throw new VolumeException.NotCurrentlyValidException("Unpledge Account unknown");
            }
            verifyPledgeAndPut(transaction, senderAccount, pledgeAccount.getUnpledgeTotal(), reservedWithdrawCache);
        } else {
            verifyBalanceAndPut(transaction, senderAccount, reservedPledgeCache, reservedBalanceCache);
        }
    }

    void verifyPledgeAndPut(Transaction transaction, Account senderAccount, Long verifyAmount, HashMap<Long, Long> CacheMap) throws VolumeException.ValidationException {
        final Long amountNQT = Convert.safeAdd(CacheMap.getOrDefault(transaction.getSenderId(), 0L),
                transaction.getType().calculateTotalAmountNQT(transaction)) - transaction.getFeeNQT();
        System.out.printf("amount:%s, verifyAmount:%s", amountNQT, verifyAmount);
        if (senderAccount == null) {
            LOGGER.info(String.format(
                    "Transaction %d: Account %d does not exist and has no balance. Required funds: %d",
                    transaction.getId(), transaction.getSenderId(), amountNQT));

            throw new VolumeException.NotCurrentlyValidException("Account unknown");
        } else if (amountNQT > verifyAmount) {
            LOGGER.info(
                    String.format("Transaction %d: Account %d pledge balance too low. You have  %d > %d Balance",
                            transaction.getId(), transaction.getSenderId(), amountNQT,
                            verifyAmount));

            throw new VolumeException.NotCurrentlyValidException("Insufficient funds to pledge");
        }
        CacheMap.put(transaction.getSenderId(), amountNQT);
    }

    void verifyBalanceAndPut(Transaction transaction, Account senderAccount, HashMap<Long, Long> cacheMap, HashMap<Long, Long> writeCacheMap) throws VolumeException.ValidationException {
        final Long amountNQT = Convert.safeAdd(writeCacheMap.getOrDefault(transaction.getSenderId(), 0L),
                transaction.getType().calculateTotalAmountNQT(transaction));
        final Long amountTotalNQT = Convert.safeAdd(amountNQT, cacheMap.getOrDefault(transaction.getSenderId(), 0L));

        if (senderAccount == null) {
            LOGGER.info(String.format(
                    "Transaction %d: Account %d does not exist and has no balance. Required funds: %d",
                    transaction.getId(), transaction.getSenderId(), amountNQT));

            throw new VolumeException.NotCurrentlyValidException("Account unknown");
        } else if (amountTotalNQT > senderAccount.getUnconfirmedBalanceNQT()) {
            LOGGER.info(String.format("Transaction %d: Account %d balance too low. You have  %d > %d Balance",
                    transaction.getId(), transaction.getSenderId(), amountTotalNQT,
                    senderAccount.getUnconfirmedBalanceNQT()));

            throw new VolumeException.NotCurrentlyValidException("Insufficient funds");
        }
        writeCacheMap.put(transaction.getSenderId(), amountNQT);
    }

    void refundBalance(Transaction transaction) {
        if (transaction.getType().getType() == TransactionType.Payment.PAYMENT_TRANSACTIONS_PLEDGE.getType() && transaction.getType().getSubtype() == TransactionType.Payment.PAYMENT_TRANSACTIONS_PLEDGE.getSubtype()) {
            refundBanlance(transaction, reservedPledgeCache);
        } else if (transaction.getType().getType() == TransactionType.Payment.PAYMENT_TRANSACTIONS_UNPLEDGE.getType() && transaction.getType().getSubtype() == TransactionType.Payment.PAYMENT_TRANSACTIONS_UNPLEDGE.getSubtype()) {
            refundBanlance(transaction, reservedUnpledgeCache);
        } else if (transaction.getType().getType() == TransactionType.Payment.PAYMENT_TRANSACTIONS_WITHDRAW.getType() && transaction.getType().getSubtype() == TransactionType.Payment.PAYMENT_TRANSACTIONS_WITHDRAW.getSubtype()) {
            refundBanlance(transaction, reservedWithdrawCache);
        } else {
            refundBanlance(transaction, reservedBalanceCache);
        }
    }

    void refundBanlance(Transaction transaction, HashMap<Long, Long> balanceCache) {
        Long amountNQT = Convert.safeSubtract(balanceCache.getOrDefault(transaction.getSenderId(), 0L),
                transaction.getType().calculateTotalAmountNQT(transaction));

        if (amountNQT > 0) {
            balanceCache.put(transaction.getSenderId(), amountNQT);
        } else {
            balanceCache.remove(transaction.getSenderId());
        }
    }

    public List<Transaction> rebuild(List<Transaction> transactions) {
        clear();

        final List<Transaction> insufficientFundsTransactions = new ArrayList<>();

        for (Transaction t : transactions) {
            try {
                this.reserveBalanceAndPut(t);
            } catch (VolumeException.ValidationException e) {
                insufficientFundsTransactions.add(t);
            }
        }

        return insufficientFundsTransactions;
    }

    public void clear() {
        reservedBalanceCache.clear();
        reservedPledgeCache.clear();
        reservedUnpledgeCache.clear();
        reservedWithdrawCache.clear();
        reservedPledgeAccountCache.clear();
    }

}
