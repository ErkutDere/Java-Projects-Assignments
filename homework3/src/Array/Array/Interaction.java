package Array;
public abstract class Interaction {
    final int interactionId;
    // final int accountId;
    // final int postId;
    final Account account;
    final Post post;
/**
 * This is the constructor of abstract class interaction
 * @param interactionId
 * @param a
 * @param p
 */
    public Interaction(int interactionId, Account a, Post p) {
        this.interactionId = interactionId;
        this.account = a;
        this.post = p;
    }
/**
 * This method returns the username of an account. This information used for viewInteraction method.
 * @return username of the account
 */
    public String getUsername() {
        return account.getUserName();
    }

}
