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
public class Address {
    private String street;
    private String suite;
    private String city;
    private String zipcode;
    private Geo geo;

    @Override
    public String toString() {
        return "\n" +
                "    street: '" + street + "',\n" +
                "    suite: '" + suite + "',\n" +
                "    city: '" + city + "',\n" +
                "    zipcode: '" + zipcode + "',\n" +
                "    geo: " + geo;
    }
}
