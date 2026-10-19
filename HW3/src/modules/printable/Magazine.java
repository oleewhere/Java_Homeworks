package modules.printable;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Magazine implements Printable {
    private String name;

    @Override
    public void print() {
        System.out.println("Журнал: " + name);
    }
}