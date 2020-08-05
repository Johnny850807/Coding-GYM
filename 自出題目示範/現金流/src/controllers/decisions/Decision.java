package controllers.decisions;

/**
 * @author johnny850807@gmail.com (Waterball))
 */
public interface Decision {
    boolean isAvailable();
    void perform();
}
