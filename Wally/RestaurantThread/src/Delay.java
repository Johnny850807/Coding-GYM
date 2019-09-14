public class Delay {
    public static void seconds(int seconds) {
        milliseconds(seconds * 1000);
    }

    public static void milliseconds(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
