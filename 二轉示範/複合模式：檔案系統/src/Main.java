import java.util.Scanner;

/**
 * @author johnny850807@gmail.com (Waterball))
 */
@SuppressWarnings("InfiniteLoopStatement")
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Commandline CLI = new Commandline();
        CLI.start();

        while (true) {
            String nextCommand = scanner.nextLine().trim();
            CLI.executeCommand(nextCommand);
        }
    }
}
