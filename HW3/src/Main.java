import modules.printable.*;
import modules.instrument.*;

public class Main {
    public static void main(String[] args) {
        //Printable
        Printable[] printables = {
                new Book("Forsaken"),
                new Magazine("PC Gamer"),
                new Book("Song of Ice and Fire")
        };

        for (Printable item : printables) {
            item.print();
        }
        System.out.println("================================");

        //Instrument
        Instrument[] instruments = {
                new Guitar(6),
                new Drum(35),
                new Trumpet(11.7)
        };

        for (Instrument instrument : instruments) {
            instrument.play();
        }
    }
}