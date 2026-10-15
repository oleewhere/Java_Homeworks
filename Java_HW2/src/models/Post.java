package models;

import java.util.ArrayList;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Post {
    private int userId;
    private int id;
    private String title;
    private String body;

    @Builder.Default
    private ArrayList<Comment> comments = new ArrayList<>();

    @Override
    public String toString() {
        String commentsList = "";
        for (Comment comment : comments) {
            commentsList += "\n  " + comment;
        }
        return "Post #" + id + ": " + title + "\n" +
                "Body: " + body + "\n" +
                "Comments (" + comments.size() + "):" + commentsList + "\n" +
                "=====================================================";
    }
}

