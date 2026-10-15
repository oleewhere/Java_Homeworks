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
public class Geo {
    private String lat;
    private String lng;

    @Override
    public String toString() {
        return "{lat: '" + lat + "', lng: '" + lng + "'}";
    }
}
