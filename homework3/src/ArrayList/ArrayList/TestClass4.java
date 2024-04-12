package ArrayList;

import java.util.ArrayList;

public class TestClass4 {
    public static void main(String[] args) {
        long startTime = System.nanoTime();
        System.out.println("... Creating accounts...");
        Account gizemsungu = new Account(1, "gizemsungu", "13.01.1993", "Istanbul");
        Account sibelgulmez = new Account(2, "sibelgulmez", "14.01.1994", "Ankara");
        Account gokhankaya = new Account(3, "gokhankaya", "12.10.1990", "Los Angeles");
        Account mehmetoz = new Account(4, "mehmetoz", "20.06.1964", "New York");
        Account paulnewman = new Account(5, "paulnewman", "14.07.1946", "London");
        Account jennifferowen = new Account(6, "jenniferowen", "20.01.1980", "Paris");
        Account sarahpaulson = new Account(7, "sarahpaulson", "13.11.1992", "Tokyo");
        Account minlee = new Account(8, "minlee", "07.06.2000", "Seoul");
        Account josephlawson = new Account(9, "josephlawson", "04.04.1984", "Sydney");
        Account harperlee = new Account(10, "harperlee", "20.03.1999", "Alabama");
        sibelgulmez.login();
        Post post1 = new Post("I like Java...", sibelgulmez, 1, 2);
        Post post2 = new Post("Java the coffee...", sibelgulmez, 2, 2);
        sibelgulmez.addPost(post1);
        sibelgulmez.addPost(post2);
        sibelgulmez.follow(gokhankaya);
        sibelgulmez.follow(harperlee);
        sibelgulmez.unfollow(harperlee);
        sibelgulmez.logout();
        gokhankaya.login();
        Like like1 = new Like(0, gokhankaya, post1);
        Like like2 = new Like(1, gokhankaya, post2);
        post1.addLike(like1);
        post2.addLike(like2);
        post2.unlike(like2);
        System.out.println(post2.getLikes().size());
        gokhankaya.block(harperlee);
        gokhankaya.block(minlee);
        gokhankaya.unblock(harperlee);
        System.out.println(gokhankaya.getBlockedAccounts().size());
        System.out.println("-----");
        Comment comment1 = new Comment(0, "'me too!'", gokhankaya, post1);
        post1.addComment(comment1);
        post1.viewComments();
        System.out.println(post1.getComments().size());
        post1.unComment(comment1);
        post1.viewComments();
        System.out.println(post1.getComments().size());
        gokhankaya.viewPostInteraction(sibelgulmez);
        gokhankaya.viewProfile(sibelgulmez);
        gokhankaya.logout();
        mehmetoz.login();
        Like like3 = new Like(2, mehmetoz, post1);
        post1.addLike(like3);
        Comment comment2 = new Comment(1, "Very nice post!", mehmetoz, post1);
        post1.addComment(comment2);
        mehmetoz.viewPostInteraction(sibelgulmez);
        long endTime = System.nanoTime();
        long totalTime = endTime - startTime;
        System.out.println(totalTime);
    }
}
