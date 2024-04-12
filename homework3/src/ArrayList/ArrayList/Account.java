package ArrayList;

import java.util.ArrayList;

/**
 * Account class
 */
public class Account {
    private int accountId;
    private String username;
    private String birthDate;
    private String location;
    private ArrayList<Post> posts;
    private ArrayList<Account> followers;
    private ArrayList<Account> following;
    private ArrayList<Message> inbox;
    private ArrayList<Message> outbox;
    private boolean loggedIn;
    private ArrayList<Account> blockedAccounts;

    /**
     * Account constructor: Creates a new Account object with the given parameters.
     *
     * @param accountId the account ID
     * @param username  the account username
     * @param birthDate the account birth date
     * @param location  the account location
     */
    public Account(int accountId, String username, String birthDate, String location) {
        this.accountId = accountId;
        this.username = username;
        this.birthDate = birthDate;
        this.location = location;
        this.posts = new ArrayList<>();
        this.followers = new ArrayList<>();
        this.following = new ArrayList<>();
        this.inbox = new ArrayList<>();
        this.outbox = new ArrayList<>();
        this.loggedIn = false;
        this.blockedAccounts = new ArrayList<>();
        System.out.println("An account with username " + username + " has been created.");
    }

    /**
     * Returns the account username.
     *
     * @return the account username
     */
    public String getUserName() {
        return username;
    }

    /**
     * Returns the account ID.
     *
     * @return the account ID
     */
    public int getAccountId() {
        return accountId;
    }

    /**
     * Logs in to the account.
     */
    public void login() {
        if (loggedIn) {
            System.out.println("Another user is already logged in. Please try again later.");
        } else {
            loggedIn = true;
            System.out.println("Logging into an account (username:" + username + ")…");
        }
    }

    /**
     * Logs out from the account.
     */
    public void logout() {
        if (loggedIn) {
            loggedIn = false;
            System.out.println("Logging out from account (username:" + username + ")…");
        }
    }

    /**
     * Returns an ArrayList of the account's followers.
     * 
     * @return followers
     */
    public ArrayList<Account> getFollowers() {
        return followers;
    }

    /**
     * Returns an ArrayList of the account's following.
     * 
     * @return following
     */
    public ArrayList<Account> getFollowing() {
        return following;
    }

    /**
     * Returns an ArrayList of the account's posts.
     *
     * @return posts
     */
    public ArrayList<Post> getPost() {
        return posts;
    }

    /**
     * Returns an ArrayList of the account's blocked accounts.
     * 
     * @return blockedAccounts
     */
    public ArrayList<Account> getBlockedAccounts() {
        return blockedAccounts;
    }

    /**
     * Views the posts of the given account.
     *
     * @param account
     */
    public void viewPosts(Account account) {
        int blockFlag = 0;
        for (Account blockedAccount : account.blockedAccounts) {
            if (blockedAccount.getAccountId() == this.accountId) {
                blockFlag = 1;
            }
        }
        if (blockFlag == 0) {
            for (Post post : account.posts) {
                System.out
                        .println("(PostID: " + post.getId() + ")" + " " + account.username + ": " + post.getContent());
            }
        }
    }

    /**
     * Adds the given post to the account's posts.
     *
     * @param post
     */
    public void addPost(Post post) {
        if (posts.size() < 100) {
            posts.add(post);
        }
    }

    /**
     * 
     * This method adds account's followers to following ArrayList
     * 
     * @param account
     */
    public void follow(Account account) {
        if (following.size() < 100) {
            following.add(account);
            account.addFollower(this);
        }
    }

    /**
     * This method adds account's followers to followers ArrayList.
     * 
     * @param account
     */
    public void addFollower(Account account) {
        if (followers.size() < 100) {
            followers.add(account);
        }
    }

    /**
     * This method removes unfollowed accounts from account's following ArrayList
     * 
     * @param account
     */
    public void unfollow(Account account) {
        if (following.size() > 0) {
            following.remove(account);
            account.removeFollower(this);
        }
    }

    /**
     * This method removes unfollowed accounts from the account's followers
     * ArrayList
     * 
     * @param account
     */
    public void removeFollower(Account account) {
        if (followers.size() > 0) {
            followers.remove(account);
        }
    }

    /**
     * This method used for users to view profile of a account
     * 
     * @param a
     */
    public void viewProfile(Account a) {
        int blockFlag = 0;
        for (Account blockedAccount : a.blockedAccounts) {
            if (blockedAccount.accountId == this.accountId) {
                blockFlag = 1;
            }
        }
        if (blockFlag == 0) {
            System.out.println("User ID: " + a.accountId);
            System.out.println("Username: " + a.username);
            System.out.println("Location: " + a.location);
            System.out.println("Birth Date: " + a.birthDate);
            System.out.println(
                    a.username + " is following " + a.following.size() + " account(s) and has " + a.followers.size()
                            + " follower(s).");
            System.out.print("The followers of " + a.username + " are: ");
            for (Account follower : a.followers) {
                System.out.print(follower.username);
                System.out.print(",");
            }
            System.out.println("");
            System.out.print(a.username + " is following: ");
            for (Account following : a.following) {
                System.out.print(following.username);
                System.out.print(",");
            }
            System.out.println("");
            System.out.println(a.username + " has " + a.getPost().size() + " posts.");
        } else {
            System.out.println("You are blocked!");
        }
    }

    /**
     * Returns inbox ArrayList
     * 
     * @return inbox
     */
    public ArrayList<Message> getInbox() {
        return inbox;
    }

    /**
     * Returns outbox ArrayList
     * 
     * @return outbox
     */
    public ArrayList<Message> getOutbox() {
        return outbox;
    }

    /**
     * This method used for viewing inbox messages
     * 
     * @param a
     */
    public void viewInbox(Account a) {
        ArrayList<Message> inbox = a.getInbox();
        for (Message message : inbox) {
            System.out.println("Message ID: " + message.getMessageId());
            System.out.println("From: " + message.getSender().getUserName());
            System.out.println("To: " + message.getReceiver().getUserName());
            System.out.println("Message: " + message.getContent());
            System.out.println("");
        }
    }

    /**
     * This method adds message to account's inbox
     * 
     * @param a
     * @param m1
     */
    public void addMessageToInbox(Account a, Message m1) {
        boolean isBlocked = false;
        for (Account blockedAccount : this.blockedAccounts) {
            if (blockedAccount.getAccountId() == a.getAccountId()) {
                isBlocked = true;
                break;
            }
        }
        boolean isFollower = false;
        for (Account follower : this.followers) {
            if (follower.getAccountId() == a.getAccountId()) {
                isFollower = true;
                break;
            }
        }
        if (isBlocked) {
            System.out.println("You are blocked from this account you can't send a message.");
        } else if (!isFollower) {
            System.out.println("You have to follow this account to send a message.");
        } else {
            this.inbox.add(m1);
        }
    }

    /**
     * This method adds message to account's outbox
     * 
     * @param a
     * @param m1
     */
    public void addMessageToOutbox(Account a, Message m1) {
        this.outbox.add(m1);
    }

    /**
     * This method blocks account
     * 
     * @param account
     */
    public void block(Account account) {
        blockedAccounts.add(account);
    }

    /**
     * This method unblocks account
     * 
     * @param account
     */
    public void unblock(Account account) {
        blockedAccounts.remove(account);
    }

    /**
     * This method views Post interaction
     * @param a
     */
    public void viewPostInteraction(Account a) {
        int blockFlag = 0;
        for (int i = 0; i < a.blockedAccounts.size(); ++i) {
            if (a.blockedAccounts.get(i).getAccountId() == this.accountId) {
                blockFlag = 1;
            }
        }
        if (blockFlag == 0) {
            for (int i = 0; i < a.posts.size(); i++) {
                System.out.println("(PostID: " + a.posts.get(i).getId() + "): " + a.getPost().get(i).getContent() + "");
                System.out.print("The post was liked by the following account(s): ");
                for (int j = 0; j < a.getPost().get(i).getLikes().size(); j++) {
                    System.out.print(a.getPost().get(i).getLikes().get(j).getUsername() + ",");
                }
                System.out.println("");
                System.out.println("The post has " + a.posts.get(i).getComments().size() + " comment(s)...");

                for (int j = 0; j < a.posts.get(i).getComments().size(); j++) {
                    System.out.println(
                            "Comment " + (j + 1) + ": '" + a.getPost().get(i).getComments().get(j).getUsername()
                                    + "' said '" + a.getPost().get(i).getComments().get(j).getContent() + "'");
                }
            }
        }
        System.out.println("");
    }

}