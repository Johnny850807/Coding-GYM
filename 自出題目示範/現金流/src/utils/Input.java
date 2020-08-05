package utils;

import players.decisions.Decision;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

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

    public static Decision nextDecision(Decision ...decisions) {
        int input;
        String message = "請選擇 " + Arrays.stream(decisions)
                .map(d -> String.format("(%d) %s", d.getNumber(), d.getName()))
                .collect(Collectors.joining(" "));
        boolean valid;
        do {
            input = nextInt(message);
            int finalInput = input;
            valid = Arrays.stream(decisions)
                    .anyMatch(d -> d.getNumber() == finalInput);
            if (!valid) {
                System.err.println("請輸入合法選項");
            }
        } while (!valid);
        int finalDecisionNumber = input;

        return Arrays.stream(decisions)
                .filter(d -> finalDecisionNumber == d.getNumber())
                .findFirst().orElseThrow(() -> new IllegalStateException("Implementation bug"));
    }
}
