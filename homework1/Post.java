package homework1;

public class Post {
    private int postId;
    private int accountId;
    private Like[] likes;
    private Comment[] comments;
    private String content;

    private Account author;
    private int likeCount;
    private int commentCount;

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
        this.likeCount = 0;
        this.likes = new Like[10];
        this.commentCount = 0;
        this.comments = new Comment[10];
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
     * This method gets the like count number
     * 
     * @return likeCount number
     */
    public int getLikeCount() {
        return likeCount;
    }

    /**
     * This method returns the array of likes.
     * 
     * @return array of likes.
     */
    public Like[] getLikes() {
        return likes;
    }

    /**
     * This method returns the comment number of the post.
     * 
     * @return commentCount object.
     */
    public int getCommentCount() {
        return commentCount;
    }

    /**
     * This method returns the comments array of the post.
     * 
     * @return comments array
     */
    public Comment[] getComments() {
        return comments;
    }

    /**
     * This method adds the like object into likes array of the post.
     * 
     * @param l
     */
    public void addLike(Like l) {
        likes[likeCount] = l;
        likeCount++;
    }

    /**
     * This method used for viewing the comments of the post.
     */
    public void viewComments() {
        if (commentCount == 0) {
            System.out.println("There is no comments on this post");
        }
        for (int i = 0; i < commentCount; i++) {
            System.out.println("Comment " + (i + 1) + " '" + comments[i].account.getUserName() + " said "
                    + comments[i].getContent());
        }
    }

    /**
     * This method adds the comment object into comments array of the post.
     * 
     * @param comment
     */
    public void addComment(Comment comment) {
        comments[commentCount] = comment;
        commentCount++;
    }

}
