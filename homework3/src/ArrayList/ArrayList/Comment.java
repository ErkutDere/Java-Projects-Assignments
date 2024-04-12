package ArrayList;

public class Comment extends Interaction {
    private String content;
/**
 * 
 * @param interaction
 * @param content
 * @param author
 * @param post
 */
    public Comment(int interaction, String content, Account author, Post post) {
        super(interaction, author, post);
        this.content = content;
    }
    /**
     * This method returns comment owner
     * @return comment owner 
     */
    public Account commentOwner(){
        return super.account;
    }
    /**
     * This method returns content of the comment
     * @return content of the comment
     */
    public String getContent() {
        return content;
    }
/**
 * This is setter function for Comment class.
 * @param c
 */
    public void setContent(String c) {
        this.content = c;
    }
}
