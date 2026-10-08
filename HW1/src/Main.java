import classes.Posts;
import classes.Comments;
import classes.Book;
import classes.Dog;
import classes.Car;

import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        //Posts
        List<Posts> posts = new ArrayList<>();
        posts.add(new Posts(1, 1, "First post", "Body of first post"));
        posts.add(new Posts(1, 7, "Seventh post", "Body of seventh post"));
        posts.add(new Posts(2, 11, "Eleventh post", "Body of eleventh post"));
        posts.add(new Posts(2, 14, "Fourteenth post", "Body of fourteenth post"));
        posts.add(new Posts(4, 25, "Twenty-fifth post", "Body of twenty-fifth post"));

        System.out.println("Posts:");
        for (Posts post : posts) {
            System.out.println("userId: " + post.getUserId());
            System.out.println("id: " + post.getId());
            System.out.println("title: " + post.getTitle());
            System.out.println("body: " + post.getBody());
            System.out.println("----------");
        }

        //Comments
        List<Comments> comments = new ArrayList<>();
        comments.add(new Comments(1, 1, "Comment name 1", "Eliseo@gardner.biz", "Comment text 1"));
        comments.add(new Comments(1, 4, "Comment name 4", "Lew@alysha.tv", "Comment text 4"));
        comments.add(new Comments(3, 13, "Comment name 13", "Kariane@jadyn.tv", "Comment text 13"));
        comments.add(new Comments(5, 24, "Comment name 24", "Jeffery@juwan.us", "Comment text 24"));
        comments.add(new Comments(6, 27, "Comment name 27", "Francesco.Gleason@nella.us", "Comment text 27"));

        System.out.println("Comments:");
        for (Comments comment : comments) {
            System.out.println("postId: " + comment.getPostId());
            System.out.println("id: " + comment.getId());
            System.out.println("name: " + comment.getName());
            System.out.println("email: " + comment.getEmail());
            System.out.println("body: " + comment.getBody());
            System.out.println("----------");
        }

        //Book
        Book book = new Book("The Last Wish", "Andrzej Sapkowski", 1993);
        System.out.println("Book: " + book.getTitle() + ", " + book.getAuthor() + ", " + book.getYear());
        System.out.println("----------");

        //Dog
        Dog dog = new Dog("Aitor", "Labrador", 2);
        System.out.println("Dog: " + dog.getName() + ", " + dog.getBreed() + ", " + dog.getAge());
        System.out.println("----------");

        //Car
        Car car = new Car("Tesla", "Model S", 2021);
        System.out.println("Car: " + car.getBrand() + ", " + car.getModel() + ", " + car.getYear());
        System.out.println("----------");
    }
}
