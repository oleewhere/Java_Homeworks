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
public class Company {
    private String name;
    private String catchPhrase;
    private String bs;

    @Override
    public String toString() {
        return "\n" +
                "    name: '" + name + "',\n" +
                "    catchPhrase: '" + catchPhrase + "',\n" +
                "    bs: '" + bs;
    }
}
