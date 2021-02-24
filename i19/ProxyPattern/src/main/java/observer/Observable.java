package observer;

/**
 * @author i19
 */
public interface Observable {
    void addDisplay(Display display);

    void deleteDisplay(Display display);

    void update(String name);

}


