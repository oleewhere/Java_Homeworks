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
public class Specs {
    private int year;
    private int power;

    @Override
    public String toString() {
        return "{year: " + year + ", power: " + power + "}";
    }
}
