package user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Skill {
    private String title;
    private int exp;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Skill skill = (Skill) o;
        return exp == skill.exp && Objects.equals(title, skill.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, exp);
    }

    @Override
    public String toString() {
        return "Skill{" +
                "title='" + title + '\'' +
                ", exp=" + exp +
                '}';
    }
}