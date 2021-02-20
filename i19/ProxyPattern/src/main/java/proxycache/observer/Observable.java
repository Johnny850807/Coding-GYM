package proxycache.observer;

/**
 * @author i19
 */
public interface Observable {
    void addDisplay(Display display);
    void deleteDisplay(Display display);
    void notifyDisplay(String productIds);

}


