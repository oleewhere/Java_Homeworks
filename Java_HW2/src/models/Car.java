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
public class Car {
    private String model;
    private Specs specs;

    @Override
    public String toString() {
        return "{model: '" + model + "', year: " + specs.getYear() + ", power: " + specs.getPower() + "}" + "\n" + "=====================================================";
    }
}
