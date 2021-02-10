package utils.printer;

import static config.Constants.*;

/**
 * @author - wally55077@gmail.com
 */
public class Printer {

    public static void printSystemInfoMessage(String regex, String... params) {
        printInfoMessage($ + SPACE, regex, params);
    }

    public static void printSystemErrorMessage(String regex, String... params) {
        printErrorMessage($ + SPACE, regex, params);
    }

    public static void printUserMessage(String... params) {
        printInfoMessage(COLON, SPACE, params);
    }

    public static void printlnSystemInfoMessage(String regex, String... params) {
        printlnInfoMessage($ + SPACE, regex, params);
    }

    public static void printlnSystemErrorMessage(String regex, String... params) {
        printlnErrorMessage($ + SPACE, regex, params);
    }

    public static void printlnUserMessage(String... params) {
        printlnInfoMessage(COLON, SPACE, params);
    }

    public static void printlnUserMessage(String regex, String... params) {
        printlnInfoMessage(COLON + SPACE, regex, params);
    }

//    private static void printlnMessage(String punctuation, String regex, String... params) {
//        printlnInfoMessage(punctuation, regex, params);
//    }

    private static void printInfoMessage(String punctuation, String regex, String... params) {
        System.out.print(transFormMessage(punctuation, regex, params));
    }

    private static void printErrorMessage(String punctuation, String regex, String... params) {
        System.err.print(transFormMessage(punctuation, regex, params));
    }

    private static void printlnInfoMessage(String punctuation, String regex, String... params) {
        System.out.println(transFormMessage(punctuation, regex, params));
    }

    private static void printlnErrorMessage(String punctuation, String regex, String... params) {
        System.err.println(transFormMessage(punctuation, regex, params));
    }

    private static String transFormMessage(String punctuation, String regex, String... params) {
        String[] regexSplit = regex.split(BRACES_SPLIT);
        int regexSplitLength = regexSplit.length;
        StringBuilder text = new StringBuilder(punctuation);
        if (regex.contains(BRACES)) {
            for (int index = 0; index < regexSplitLength; index++) {
                text.append(regexSplit[index]).append(SPACE).append(getParam(index, params)).append(SPACE);
            }
        } else {
            text.append(regex);
        }
        return text.toString();
    }

    private static String getParam(int index, String[] params) {
        if (index >= params.length) {
            return EMPTY;
        }
        return params[index];
    }
}
