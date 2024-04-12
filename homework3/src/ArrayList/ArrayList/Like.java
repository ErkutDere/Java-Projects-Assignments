package ArrayList;

public class Like extends Interaction {
    /**
     * This subclass extends interaction class and uses it's parent constructor.
     * @param interactionId
     * @param a
     * @param p
     */
    public Like(int interactionId, Account a, Post p) {
        super(interactionId, a, p);
    }
/**
 * This method used for viewing post's likes account's. It returns account object.
 * @return Account object
 */
    public Account likeOwner() {
        return super.account;
    }

}
