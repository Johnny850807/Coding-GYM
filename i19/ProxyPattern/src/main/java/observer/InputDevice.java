package observer;

import exception.WebException;
import proxy.Service;
import proxy.ServiceProxyImpl;
import proxy.ServiceRepositoryImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author i19
 */
public class InputDevice implements Observable {
    public static final Scanner IN = new Scanner(System.in);
    private final Service serviceProxy = new ServiceProxyImpl(new ServiceRepositoryImpl());

    private final List<Display> displays;

    public InputDevice() {
        displays = new ArrayList<>();
    }

    public void enterKeywords() throws InterruptedException, WebException {
        do {
            System.out.println("輸入產品名字");
            this.notifyDisplay(serviceProxy.getIds(IN.next()));
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
    public void notifyDisplay(String productIds) {
        this.displays.forEach(display -> display.update(productIds));
    }
}


