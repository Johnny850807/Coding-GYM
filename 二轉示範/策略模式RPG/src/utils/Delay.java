package utils;

/**
 * @author johnny850807@gmail.com (Waterball))
 */
public class Delay {
    public static void delay(long ms) {
        try {
            Thread.sleep(0);
        } catch (InterruptedException ignored) { }
    }
}
