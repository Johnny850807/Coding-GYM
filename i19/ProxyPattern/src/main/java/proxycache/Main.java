package proxycache;

import proxycache.exception.WebException;
import proxycache.observer.Display;
import proxycache.observer.InputDevice;
import proxycache.observer.ProductDetail;

/**
 * @author i19
 */
public class Main {
    public static void main(String[] args) throws WebException, InterruptedException {
        InputDevice inputDevice = new InputDevice();
        Display display = new ProductDetail();
        inputDevice.addDisplay(display);
        inputDevice.getInput();
    }

}


