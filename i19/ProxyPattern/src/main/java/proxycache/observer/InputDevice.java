package proxycache.observer;

import proxycache.exception.WebException;
import proxycache.proxy.Service;
import proxycache.proxy.ServiceProxyImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author i19
 */
public class InputDevice implements Observable{
    public static final Scanner IN = new Scanner(System.in);
    private final Service serviceProxy = new ServiceProxyImpl();
    private String input;

    public void getInput() throws InterruptedException, WebException {
        while (true){
            System.out.println("輸入產品名字");
            this.notifyDisplay(serviceProxy.getName(IN.next()));
        }
    }

    private final List<Display> displays = new ArrayList<>();

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


