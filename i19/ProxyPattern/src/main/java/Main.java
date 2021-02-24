import observer.Display;
import observer.InputDevice;
import observer.ProductDetail;

/**
 * @author i19
 */
public class Main {
    public static void main(String[] args) {
        InputDevice inputDevice = new InputDevice();
        Display display = new ProductDetail();
        inputDevice.addDisplay(display);
        inputDevice.enterKeywords();
    }
}


