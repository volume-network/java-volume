package vlm.services;

import vlm.Account;
import vlm.Block;
import vlm.Subscription;
import vlm.db.DbIterator;

public interface SubscriptionService {

    Subscription getSubscription(Long id);

    DbIterator<Subscription> getSubscriptionsByParticipant(Long accountId);

    DbIterator<Subscription> getSubscriptionsToId(Long accountId);

    void addSubscription(Account sender, Account recipient, Long id, Long amountNQT, int startTimestamp, int frequency);

    boolean isEnabled();

    void applyConfirmed(Block block, int blockchainHeight);

    void removeSubscription(Long id);

    long calculateFees(int timestamp);

    void clearRemovals();

    void addRemoval(Long id);

    long applyUnconfirmed(int timestamp);
}
