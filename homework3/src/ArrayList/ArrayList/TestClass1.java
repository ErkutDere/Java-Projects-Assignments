package ArrayList;

public class TestClass1 {

    public static void main(String[] args) {
        long startTime = System.nanoTime();
        System.out.println("... Creating accounts...");
        Account gizemsungu = new Account(1, "gizemsungu", "13.01.1993", "Istanbul");
        Account sibelgulmez = new Account(2, "sibelgulmez", "14.01.1994", "Ankara");
        Account gokhankaya = new Account(3, "gokhankaya", "12.10.1990", "Los Angeles");
        sibelgulmez.login();
        System.out.println("Sharing two posts...");
        Post post1 = new Post("I like Java...", sibelgulmez, 1, 2);
        Post post2 = new Post("Java the coffee...", sibelgulmez, 2, 2);

        sibelgulmez.addPost(post1);
        sibelgulmez.addPost(post2);
        System.out.println("Following gizemsungu and gokhankaya...");
        sibelgulmez.follow(gizemsungu);
        sibelgulmez.follow(gokhankaya);
        sibelgulmez.logout();

        gokhankaya.login();
        System.out.println("Viewing sibelgulmez's profile...");
        gokhankaya.viewProfile(sibelgulmez);
        System.out.println("Viewing sibelgulmez'posts...");
        gokhankaya.viewPosts(sibelgulmez);
        System.out.println("Liking a post of sibelgulmez...");
        Like like1 = new Like(0, gokhankaya, post1);
        post1.addLike(like1);

        System.out.println("Adding a comment on a post of sibelgulmez...");
        Comment comment1 = new Comment(0, "'me too!'", gokhankaya, post1);
        post1.addComment(comment1);

        System.out.println("Following sibelgulmez and gizemsungu...");
        gokhankaya.follow(sibelgulmez);
        gokhankaya.follow(gizemsungu);
        System.out.println("Sending a message to gizemsungu...");
        Message message1 = new Message(0, gokhankaya, gizemsungu, "This homework is too easy!");
        gokhankaya.logout();
        gizemsungu.login();
        System.out.println("Checking outbox...");
        System.out.println("There is/are " + gizemsungu.getOutbox().size() + " message(s) in the outbox.");
        System.out.println("Checking inbox...");
        System.out.println("There is/are " + gizemsungu.getInbox().size() + " message(s) in the inbox.");
        System.out.println("Viewing inbox...");
        gizemsungu.viewInbox(gizemsungu);
        System.out.println("Viewing sibelgulmez's profile...");
        gizemsungu.viewProfile(sibelgulmez);
        System.out.println("Viewing sibelgulmez's posts...");
        gizemsungu.viewPosts(sibelgulmez);
        System.out.println("---------");
        System.out.println("Viewing sibelgulmez's posts' interactions...");
        gizemsungu.viewPostInteraction(sibelgulmez);
        System.out.println("Liking sibelgulmez's posts...");
        Like like2 = new Like(0, gizemsungu, post1);
        Like like3 = new Like(1, gizemsungu, post2);
        post1.addLike(like2);
        post2.addLike(like3);
        System.out.println("---------");
        System.out.println("Viewing sibelgulmez's posts' interactions...");
        gizemsungu.viewPostInteraction(sibelgulmez);
        long endTime = System.nanoTime();
        long totalTime = endTime - startTime;
        System.out.println(totalTime);
    }

}
