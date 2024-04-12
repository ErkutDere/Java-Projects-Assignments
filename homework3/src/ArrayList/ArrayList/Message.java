package ArrayList;
public class Message {
    private int messageId; // unique identifier for each message
    private int senderId; // array of sender IDs for all messages
    private int receiverId; // array of receiver IDs for all messages
    private String content; // array of message contents for all messages
    private Account sender;
    private Account receiver;
/**
 * Constructor for Message class
 * @param messageId
 * @param sender
 * @param receiver
 * @param content
 */
    public Message(int messageId, Account sender, Account receiver, String content) {
        // constructor to initialize message object
        this.messageId = messageId;
        this.content = content;
        this.sender = sender;
        this.receiver = receiver;
        this.senderId = sender.getAccountId();
        this.receiverId = receiver.getAccountId();
        receiver.addMessageToInbox(sender,this);
        sender.addMessageToOutbox(receiver,this);
    }
/**
 * This method used for getting messageID of the message.
 * @return messageId
 */
    public int getMessageId() {
        return messageId;
    }
/**
 * This method used for getting the SenderID of the message.
 * @return senderID
 */
    public int getSenderId() {
        return senderId;
    }
/**
 * This method used for getting receiver ID of the message.
 * @return receiverID
 */
    public int getReceiverId() {
        return receiverId;
    }
/**
 * This method gets the content of the message.
 * @return string content
 */
    public String getContent() {
        return content;
    }
/**
 * This method sets the messageID
 * @param mId
 */
    public void setMessageId(int mId) {
        this.messageId = mId;
    }
/**
 * This method returns the sender information of the message.
 * @return Account object
 */
    public Account getSender() {
        return sender;
    }
/**
 * This method returns receiver information of the message.
 * @return Account object
 */
    public Account getReceiver() {
        return receiver;
    }
/**
 * This method sets the content of the message
 * @param content
 */
    public void setContent(String content) {
        this.content = content;
    }

}
