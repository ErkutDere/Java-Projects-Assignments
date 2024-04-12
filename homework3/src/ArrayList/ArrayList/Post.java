package ArrayList;

import java.util.ArrayList;

public class Post {
    private int postId;
    private int accountId;
    private ArrayList<Like> likes;
    private ArrayList<Comment> comments;
    private String content;
    private Account author;

    /**
     * This is constructor for Post Class.
     * 
     * @param content
     * @param author
     * @param postnum
     * @param accountId
     */
    public Post(String content, Account author, int postnum, int accountId) {
        this.content = content;
        this.author = author;
        this.likes = new ArrayList<>();
        this.comments = new ArrayList<>();
        this.postId = postnum;
        this.accountId = accountId;
    }

    /**
     * This method gets the ID of the post
     * 
     * @return postID of the post.
     */
    public int getId() {
        return postId;
    }

    /**
     * This method gets the account ID of the post
     * 
     * @return accountID of the post.
     */
    public int getAccountId() {
        return accountId;
    }

    /**
     * This method sets the ID of the post
     * 
     * @param id
     */
    public void setId(int id) {
        this.postId = id;
    }

    /**
     * This method gets the content of the post
     * 
     * @return contnet of the post
     */
    public String getContent() {
        return content;
    }

    /**
     * This method gets the author of the post
     * 
     * @return author of the post
     */
    public Account getAuthor() {
        return author;
    }

    /**
     * This method returns the ArrayList of likes.
     * 
     * @return ArrayList of likes.
     */
    public ArrayList<Like> getLikes() {
        return likes;
    }

    /**
     * This method returns the ArrayList of comments of the post.
     * 
     * @return ArrayList of comments.
     */
    public ArrayList<Comment> getComments() {
        return comments;
    }

    /**
     * This method adds the like object into likes ArrayList of the post.
     * 
     * @param l
     */
    public void addLike(Like l) {
        likes.add(l);
    }

    /**
     * Unlike a post
     * 
     * @param l
     */
    public void unlike(Like l) {
        likes.remove(l);
    }

    /**
     * This method used for viewing the comments of the post.
     */
    public void viewComments() {
        if (comments.size() == 0) {
            System.out.println("There is no comments on this post");
        }
        for (int i = 0; i < comments.size(); i++) {
            System.out.println("Comment " + (i + 1) + " '" + comments.get(i).account.getUserName() + " said "
                    + comments.get(i).getContent());
        }
    }

    /**
     * This method adds the comment object into comments ArrayList of the post.
     * 
     * @param comment
     */
    public void addComment(Comment comment) {
        comments.add(comment);
    }

    /**
     * This method removes the comment object from comments ArrayList of the post.
     * 
     * @param comment
     */
    public void unComment(Comment comment) {
        comments.remove(comment);
    }
}