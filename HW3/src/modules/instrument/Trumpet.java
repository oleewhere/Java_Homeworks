package modules.instrument;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Trumpet implements Instrument {
    private double diameter;

    @Override
    public void play() {
        System.out.println("Грає труба, діаметр: " + diameter);
    }
}
