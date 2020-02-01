package vlm.services;

import vlm.Alias;
import vlm.Attachment;
import vlm.Transaction;
import vlm.db.DbIterator;

public interface AliasService {

    Alias getAlias(long aliasId);

    Alias getAlias(String aliasName);

    Alias.Offer getOffer(Alias alias);

    long getAliasCount();

    DbIterator<Alias> getAliasesByOwner(long accountId, int from, int to);

    void addOrUpdateAlias(Transaction transaction, Attachment.MessagingAliasAssignment attachment);

    void sellAlias(Transaction transaction, Attachment.MessagingAliasSell attachment);

    void changeOwner(long newOwnerId, String aliasName, int timestamp);
}
