package vlm.db.store;

import vlm.Subscription;
import vlm.db.DbIterator;
import vlm.db.DbKey;
import vlm.db.VersionedEntityTable;

public interface SubscriptionStore {

    DbKey.LongKeyFactory<Subscription> getSubscriptionDbKeyFactory();

    VersionedEntityTable<Subscription> getSubscriptionTable();

    DbIterator<Subscription> getSubscriptionsByParticipant(Long accountId);

    DbIterator<Subscription> getIdSubscriptions(Long accountId);

    DbIterator<Subscription> getSubscriptionsToId(Long accountId);

    DbIterator<Subscription> getUpdateSubscriptions(int timestamp);
}
