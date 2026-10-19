package modules.instrument;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Guitar implements Instrument {
    private int stringsCount;

    @Override
    public void play() {
        System.out.println("Грає гітара, кількість струн: " + stringsCount);
    }
}
