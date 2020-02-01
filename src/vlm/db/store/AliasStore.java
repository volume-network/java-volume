package vlm.db.store;

import vlm.Alias;
import vlm.db.DbIterator;
import vlm.db.DbKey;
import vlm.db.VersionedEntityTable;

public interface AliasStore {
    DbKey.LongKeyFactory<Alias> getAliasDbKeyFactory();

    DbKey.LongKeyFactory<Alias.Offer> getOfferDbKeyFactory();

    VersionedEntityTable<Alias> getAliasTable();

    VersionedEntityTable<Alias.Offer> getOfferTable();

    DbIterator<Alias> getAliasesByOwner(long accountId, int from, int to);

    Alias getAlias(String aliasName);
}
