package utils;

import java.util.Collection;
import java.util.Scanner;

public class Input {
    private static final Scanner scanner = new Scanner(System.in);

    public static String nextLine(String message) {
        String input;
        System.out.print(message);
        if (!message.isEmpty())
            System.out.println();
        do {
            input = scanner.nextLine();
        } while (input.isEmpty());
        return input;
    }

    public static String next() {
        return nextLine("");  // empty message
    }

    public static String next(String message) {
        String input;
        System.out.print(message);
        if (!message.isEmpty())
            System.out.println();
        do {
            input = scanner.next();
        } while (input.isEmpty());
        return input;
    }

    public static String nextLine() {
        return nextLine("");  // empty message
    }

    public static int nextInt(String message) {
        while (true) {
            try {
                String input = next(message);
                return Integer.parseInt(input.trim());
            } catch (NumberFormatException err) {
                System.err.println("請輸入數字");
            }
        }
    }

    public static int nextInt(String message, int min, int max) {
        int input;
        do {
            input = nextInt(message);
            if (input > max || input < min) {
                System.err.println("輸入範圍" + min + "~" + max);
            }
        } while (input > max || input < min);
        return input;
    }


    public static int nextInt() {
        return nextInt("");
    }

    public static int nextInt(int min, int max) {
        return nextInt("", min, max);
    }

    public static int nextInt(String message, Collection<Integer> availableIntegers) {
        int input = nextInt(message);
        if (!availableIntegers.contains(input)) {
            return nextInt(message, availableIntegers);
        }
        return input;
    }

}
