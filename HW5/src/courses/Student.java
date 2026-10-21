package courses;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    private int id;
    private String name;
    private int age;
    private int courseYear;

    @Override
    public String toString() {
        return name + ", " + age + " yo, Course Year = " + courseYear + ", id: " + id;
    }
}