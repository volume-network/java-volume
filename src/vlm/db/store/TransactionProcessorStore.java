package vlm.db.store;

import vlm.Transaction;
import vlm.db.DbKey;
import vlm.db.sql.EntitySqlTable;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

public interface TransactionProcessorStore {
    // WATCH: BUSINESS-LOGIC
    void processLater(Collection<Transaction> transactions);

    DbKey.LongKeyFactory<Transaction> getUnconfirmedTransactionDbKeyFactory();

    Set<Transaction> getLostTransactions();

    Map<Long, Integer> getLostTransactionHeights();

    EntitySqlTable<Transaction> getUnconfirmedTransactionTable();

    int deleteTransaction(Transaction transaction);

    boolean hasTransaction(long transactionId);
}
