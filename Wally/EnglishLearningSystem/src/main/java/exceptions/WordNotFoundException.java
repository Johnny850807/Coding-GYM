package exceptions;

/**
 * @author i19
 */
public class WordNotFoundException extends EnglishSystemException {

    public WordNotFoundException(String word) {
        super("單字 " + word + " 不存在");
    }
}


