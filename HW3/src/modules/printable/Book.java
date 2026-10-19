package modules.printable;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Book implements Printable {
    private String title;

    @Override
    public void print() {
        System.out.println("Книга: " + title);
    }
}