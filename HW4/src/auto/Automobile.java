package auto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Automobile {
    private String brand;
    private int power;
    private Driver driver;
    private int price;
    private int year;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Automobile that = (Automobile) o;
        return power == that.power && Integer.compare(that.price, price) == 0 && year == that.year &&
                Objects.equals(brand, that.brand) && Objects.equals(driver, that.driver);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, power, driver, price, year);
    }

    @Override
    public String toString() {
        return "Automobile{" +
                "brand='" + brand + '\'' +
                ", power=" + power +
                ", driver=" + driver +
                ", price=" + price +
                ", year=" + year +
                '}';
    }
}