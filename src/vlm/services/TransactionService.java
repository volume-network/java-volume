package vlm.services;

import vlm.Transaction;
import vlm.VolumeException;

public interface TransactionService {

    boolean verifyPublicKey(Transaction transaction);

    void validate(Transaction transaction) throws VolumeException.ValidationException;

    boolean applyUnconfirmed(Transaction transaction);

    void apply(Transaction transaction);

    void undoUnconfirmed(Transaction transaction);
}
