package courses;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Course {
    private int courseId;
    private String courseName;
    private int studentId;
    private String studentName;

    @Override
    public String toString() {
        return "Course: " + courseName + ", course id: " + courseId + "; Student: " + studentName + ", id: " + studentId;
    }
}