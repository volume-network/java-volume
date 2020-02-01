package vlm.db.store;

import vlm.Asset;
import vlm.db.DbIterator;
import vlm.db.DbKey;
import vlm.db.sql.EntitySqlTable;

public interface AssetStore {
    DbKey.LongKeyFactory<Asset> getAssetDbKeyFactory();

    EntitySqlTable<Asset> getAssetTable();

    DbIterator<Asset> getAssetsIssuedBy(long accountId, int from, int to);
}
