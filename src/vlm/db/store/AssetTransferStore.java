package vlm.db.store;

import vlm.AssetTransfer;
import vlm.db.DbIterator;
import vlm.db.DbKey;
import vlm.db.sql.EntitySqlTable;

public interface AssetTransferStore {
    DbKey.LongKeyFactory<AssetTransfer> getTransferDbKeyFactory();

    EntitySqlTable<AssetTransfer> getAssetTransferTable();

    DbIterator<AssetTransfer> getAssetTransfers(long assetId, int from, int to);

    DbIterator<AssetTransfer> getAccountAssetTransfers(long accountId, int from, int to);

    DbIterator<AssetTransfer> getAccountAssetTransfers(long accountId, long assetId, int from, int to);

    int getTransferCount(long assetId);
}
