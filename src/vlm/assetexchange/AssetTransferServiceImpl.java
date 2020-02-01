package vlm.assetexchange;

import vlm.AssetTransfer;
import vlm.Attachment;
import vlm.Transaction;
import vlm.db.DbIterator;
import vlm.db.DbKey;
import vlm.db.sql.EntitySqlTable;
import vlm.db.store.AssetTransferStore;
import vlm.util.Listener;
import vlm.util.Listeners;

class AssetTransferServiceImpl {

    private final Listeners<AssetTransfer, AssetTransfer.Event> listeners = new Listeners<>();

    private final AssetTransferStore assetTransferStore;
    private final EntitySqlTable<AssetTransfer> assetTransferTable;
    private final DbKey.LongKeyFactory<AssetTransfer> transferDbKeyFactory;


    public AssetTransferServiceImpl(AssetTransferStore assetTransferStore) {
        this.assetTransferStore = assetTransferStore;
        this.assetTransferTable = assetTransferStore.getAssetTransferTable();
        this.transferDbKeyFactory = assetTransferStore.getTransferDbKeyFactory();
    }

    public boolean addListener(Listener<AssetTransfer> listener, AssetTransfer.Event eventType) {
        return listeners.addListener(listener, eventType);
    }

    public boolean removeListener(Listener<AssetTransfer> listener, AssetTransfer.Event eventType) {
        return listeners.removeListener(listener, eventType);
    }

    public DbIterator<AssetTransfer> getAssetTransfers(long assetId, int from, int to) {
        return assetTransferStore.getAssetTransfers(assetId, from, to);
    }

    public DbIterator<AssetTransfer> getAccountAssetTransfers(long accountId, long assetId, int from, int to) {
        return assetTransferStore.getAccountAssetTransfers(accountId, assetId, from, to);
    }

    public int getTransferCount(long assetId) {
        return assetTransferStore.getTransferCount(assetId);
    }

    public int getAssetTransferCount() {
        return assetTransferTable.getCount();
    }

    public AssetTransfer addAssetTransfer(Transaction transaction, Attachment.ColoredCoinsAssetTransfer attachment) {
        DbKey dbKey = transferDbKeyFactory.newKey(transaction.getId());
        AssetTransfer assetTransfer = new AssetTransfer(dbKey, transaction, attachment);
        assetTransferTable.insert(assetTransfer);
        listeners.notify(assetTransfer, AssetTransfer.Event.ASSET_TRANSFER);
        return assetTransfer;
    }

}
