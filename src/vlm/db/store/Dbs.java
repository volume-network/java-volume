package vlm.db.store;

import vlm.TransactionDb;
import vlm.db.BlockDb;
import vlm.db.PeerDb;

public interface Dbs {

    BlockDb getBlockDb();

    TransactionDb getTransactionDb();

    PeerDb getPeerDb();

}
