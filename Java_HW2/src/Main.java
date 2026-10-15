import models.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //User
        Geo geo = Geo.builder().lat("-37.3159").lng("81.1496").build();
        Address address = Address.builder().street("Kulas Light").suite("Apt. 556").city("Gwenborough").zipcode("92998-3874").geo(geo).build();
        Company company = Company.builder().name("Romaguera-Crona").catchPhrase("Multi-layered client-server").bs("harness real-time").build();
        User user = User.builder().id(1).name("Leanne Graham").username("Bret").email("Sincere@april.biz").phone("1-770-736-8031").website("hildegard.org").address(address).company(company).build();
        System.out.println(user);

        //Car
        Specs specs = Specs.builder().year(2021).power(250).build();
        Car toyota = Car.builder().model("toyota").specs(specs).build();
        System.out.println(toyota);

        //Person
        ArrayList<Skill> skills = new ArrayList<>(List.of(
                Skill.builder().title("java").exp(10).build(),
                Skill.builder().title("js").exp(10).build(),
                Skill.builder().title("c++").exp(10).build()
        ));
        Person person = Person.builder().id(1).name("vasya").surname("pupkin").email("asd@asd.com").age(31).gender(Gender.MALE).skills(skills).car(toyota).build();
        System.out.println(person);

        //Post
        ArrayList<Post> posts = new ArrayList<>(List.of(
                Post.builder().userId(1).id(1).title("sunt aut facere").body("quia et suscipit...").build(),
                Post.builder().userId(1).id(2).title("qui est esse").body("est rerum tempore...").build()
        ));

        //Comment
        ArrayList<Comment> comments = new ArrayList<>(List.of(
                Comment.builder().postId(1).id(1).name("id labore").email("Eliseo@gardner.biz").body("laudantium...").build(),
                Comment.builder().postId(1).id(2).name("quo vero").email("Jayne_Kuhic@sydney.com").body("est natus...").build(),
                Comment.builder().postId(2).id(3).name("odio adipisci").email("Nikita@garfield.biz").body("quia molestiae...").build()
        ));

        for (Post post : posts) {
            for (Comment comment : comments) {
                if (comment.getPostId() == post.getId()) {
                    post.getComments().add(comment);
                }
            }
            System.out.println(post);
        }
    }
}
