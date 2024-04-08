package homework1;

/**
 * @author Erkut Dere
 */
public class Account {
    private int accountId;
    private String username;
    private String birthDate;
    private String location;
    private Post[] posts;
    private Account[] followers;
    private Account[] following;
    private Message[] inbox;
    private Message[] outbox;
    private int inboxNum;
    private int outboxNum;
    private int numPosts;
    private int numFollowers;
    private int numFollowing;
    private boolean loggedIn;

    /**
     * 
     * @param accountId
     * @param username
     * @param birthDate
     * @param location
     * @param inboxNum
     * @param outboxNum
     * @param numPosts
     * @param numFollowers
     * @param NumFollowing
     * @param followers
     * @param following
     * @param inbox
     * @param outbox
     */
    public Account(int accountId, String username, String birthDate, String location) {
        this.accountId = accountId;
        this.username = username;
        this.birthDate = birthDate;
        this.location = location;
        this.posts = new Post[100];
        this.followers = new Account[100];
        this.following = new Account[100];
        this.numPosts = 0;
        this.numFollowers = 0;
        this.numFollowing = 0;
        this.inbox = new Message[100];
        this.outbox = new Message[100];
        this.inboxNum = 0;
        this.outboxNum = 0;
        this.loggedIn = false;
        System.out.println("An account with username " + username + " has been created.");
    }

    /**
     * 
     * @return Account username
     */
    public String getUserName() {
        return username;
    }

    /**
     * 
     * @return Account ID
     */
    public int getAccountId() {
        return accountId;
    }

    /**
     * Makes login operations
     */
    public void login() {
        if (loggedIn) {
            System.out.println("Another user is already logged in. Please try again later.");
        } // en son bunu yapmaya çalışıyordum 18 mart 2.50 am
        if (this.username.equals(username)) {
            loggedIn = true;
            System.out.println("Logging into an account (username:" + username + ")…");
        }
    }

    /**
     * Makes logout operations
     */
    public void logout() {
        if (this.username.equals(username)) {
            loggedIn = false;
            System.out.println("Logging out from account (username:" + username + ")…");
        }
    }

    /**
     * 
     * @return posts array
     */
    public Post[] getPost() {
        return posts;
    }

    /**
     * 
     * @param account
     *                This method used for viewing Post of an account
     */
    public void viewPosts(Account account) {
        for (int i = 0; i < account.numPosts; i++) {
            System.out.println("(PostID: " + account.getPost()[i].getId() + ")" + " " + account.username + ": "
                    + account.posts[i].getContent());
        }
    }

    /***
     * 
     * @param post
     *             This method used for adding post in posts array in account
     *             object.
     */
    public void addPost(Post post) {
        if (numPosts < 100) {
            posts[numPosts++] = post;
        }
    }

    /**
     * @param account
     *                This method adds account objects followers to its own
     *                following array
     */
    public void follow(Account account) {
        if (numFollowing < 100) {
            following[numFollowing++] = account;
            account.addFollower(this);
        }
    }

    /**
     * This method adds follower accounts to its own followers array.
     * 
     * @param account
     */
    public void addFollower(Account account) {
        if (numFollowers < 100) {
            followers[numFollowers++] = account;
        }
    }

    /**
     * This method used for users to view profile of a account
     * 
     * @param a
     */
    public void viewProfile(Account a) {
        System.out.println("User ID: " + a.accountId);
        System.out.println("Username: " + a.username);
        System.out.println("Location: " + a.location);
        System.out.println("Birth Date: " + a.birthDate);
        System.out.println(a.username + " is following " + a.numFollowing + " account(s) and has " + a.numFollowers
                + " follower(s).");
        System.out.print("The followers of " + a.username + " are: ");
        for (int i = 0; i < a.numFollowers; i++) {
            System.out.print(a.followers[i].username);
            System.out.print(",");
        }
        System.out.println("");
        System.out.print(a.username + " is following: ");
        for (int i = 0; i < a.numFollowing; i++) {
            System.out.print(a.following[i].username);
            System.out.print(",");
        }
        System.out.println("");
        System.out.println(a.username + " has " + a.numPosts + " posts.");
    }

    /**
     * This method returns inbox array
     * 
     * @return inbox array
     */
    public Message[] getInbox() {
        return inbox;
    }

    /**
     * This method returns outbox array
     * 
     * @return outbox array
     */
    public Message[] getOutbox() {
        return outbox;
    }

    /**
     * This method used for viewing inbox messages
     * 
     * @param a
     */
    public void viewInbox(Account a) {
        for (int i = 0; i < a.getInboxNum(); ++i) {
            System.out.println("Message ID: " + a.getInbox()[i].getMessageId());
            System.out.println("From: " + a.getInbox()[i].getSender().username);
            System.out.println("To: " + a.getInbox()[i].getReceiver().username);
            System.out.println("Message: " + a.getInbox()[i].getContent());
            System.out.println("");
        }
    }

    /**
     * This method returns number of post numbers of an account
     * 
     * @return number of post
     */
    public int getPostNum() {
        return numPosts;
    }

    /**
     * This method adds the message to inbox array of an account object
     * 
     * @param m1
     */
    public void addMessageToInbox(Message m1) {
        inbox[inboxNum++] = m1;
    }

    /**
     * This method adds the message to outbox array of an account object.
     * 
     * @param m1
     */

    public void addMessageToOutbox(Message m1) {
        outbox[outboxNum++] = m1;
    }

    /**
     * This method returns the size of the inbox array
     * 
     * @return inbox number
     */
    public int getInboxNum() {
        return inboxNum;
    }

    /**
     * This method returns the size of the outbox array
     * 
     * @return outbox number
     */
    public int getOutboxNum() {
        return outboxNum;
    }

    /**
     * This method gets Account parameter and tries to print Account's interactions
     * to console.
     * 
     * @param a
     */
    public void viewPostInteraction(Account a) {
        for (int i = 0; i < a.numPosts; i++) {
            System.out.println("(PostID: " + a.getPost()[i].getId() + "): " + a.getPost()[i].getContent() + "");
            System.out.print("The post was liked by the following account(s): ");
            for (int j = 0; j < a.getPost()[i].getLikeCount(); j++) {
                System.out.print(a.getPost()[i].getLikes()[j].likeOwner().getUserName() + ",");
            }
            System.out.println("");
            System.out.println("The post has " + a.getPost()[i].getCommentCount() + " comment(s)...");

            for (int j = 0; j < a.getPost()[i].getCommentCount(); j++) {
                System.out.println("Comment " + a.getPost()[i].getCommentCount() + ": '"
                        + a.getPost()[i].getComments()[j].getUsername() + "' said '"
                        + a.getPost()[i].getComments()[j].getContent() + "'");
            }
        }
        System.out.println("");
    }
}