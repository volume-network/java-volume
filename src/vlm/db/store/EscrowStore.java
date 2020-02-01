package vlm.db.store;

import vlm.Escrow;
import vlm.Transaction;
import vlm.db.DbIterator;
import vlm.db.DbKey;
import vlm.db.VersionedEntityTable;

import java.util.Collection;
import java.util.List;

public interface EscrowStore {

    DbKey.LongKeyFactory<Escrow> getEscrowDbKeyFactory();

    VersionedEntityTable<Escrow> getEscrowTable();

    vlm.db.sql.DbKey.LinkKeyFactory<Escrow.Decision> getDecisionDbKeyFactory();

    VersionedEntityTable<Escrow.Decision> getDecisionTable();

    Collection<Escrow> getEscrowTransactionsByParticipant(Long accountId);

    List<Transaction> getResultTransactions();

    DbIterator<Escrow.Decision> getDecisions(Long id);
}
