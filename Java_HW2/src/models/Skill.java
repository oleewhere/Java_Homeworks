package models;

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
public class Skill {
    private String title;
    private int exp;

    @Override
    public String toString() {
        return "{title: '" + title + "', exp: " + exp + "}";
    }
}
