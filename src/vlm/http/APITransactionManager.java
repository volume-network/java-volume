package vlm.http;

import com.google.gson.JsonElement;
import vlm.Account;
import vlm.Attachment;
import vlm.VolumeException;

import javax.servlet.http.HttpServletRequest;

public interface APITransactionManager {

    JsonElement createTransaction(HttpServletRequest req, Account senderAccount, Long recipientId, long amountNQT, Attachment attachment, long minimumFeeNQT) throws VolumeException;

}
