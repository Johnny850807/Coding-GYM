package observer;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author i19
 */
public class InputDevice implements Observable {
    public static final Scanner IN = new Scanner(System.in);

    private final List<Display> displays = new ArrayList<>();

    public void enterKeywords() {
        do {
            System.out.println("輸入產品名字");
            this.update(IN.next());
            System.out.println("繼續查詢(Y/N)");
        } while ("Y".equals(IN.next().toUpperCase()));
    }

    @Override
    public void addDisplay(Display display) {
        this.displays.add(display);
    }

    @Override
    public void deleteDisplay(Display display) {
        this.displays.remove(display);
    }

    @Override
    public void update(String name) {
        this.displays.forEach(display -> display.onUpdate(name));
    }
}


