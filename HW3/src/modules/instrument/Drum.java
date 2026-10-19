package modules.instrument;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Drum implements Instrument {
    private int size;

    @Override
    public void play() {
        System.out.println("Грає барабан, розмір: " + size);
    }
}
