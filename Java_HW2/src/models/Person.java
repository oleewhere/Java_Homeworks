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
public class Person {
    private int id;
    private String name;
    private String surname;
    private String email;
    private int age;
    private Gender gender;
    private ArrayList<Skill> skills;
    private Car car;

    @Override
    public String toString() {
        return "Person:\n" +
                "  id: " + id + ",\n" +
                "  name: '" + name + "',\n" +
                "  surname: '" + surname + "',\n" +
                "  email: '" + email + "',\n" +
                "  age: " + age + ",\n" +
                "  gender: '" + gender + "',\n" +
                "  skills: " + skills + ",\n" +
                "  car: " + car + "\n";
    }
}
