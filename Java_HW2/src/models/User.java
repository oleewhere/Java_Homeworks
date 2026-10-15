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
public class User {
    private int id;
    private String name;
    private String username;
    private String email;
    private Address address;
    private String phone;
    private String website;
    private Company company;

    @Override
    public String toString() {
        return "===================================================== \n" +
                "User: \n" +
                "  id: " + id + ",\n" +
                "  name: '" + name + "',\n" +
                "  username: '" + username + "',\n" +
                "  email: '" + email + "',\n" +
                "  address: " + address + ",\n" +
                "  phone: '" + phone + "',\n" +
                "  website: '" + website + "',\n" +
                "  company: " + company + "\n" +
                "=====================================================";
    }
}
