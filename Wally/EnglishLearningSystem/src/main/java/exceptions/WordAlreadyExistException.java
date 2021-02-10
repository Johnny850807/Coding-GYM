package exceptions;

/**
 * @author - wally55077@gmail.com
 */
public class WordAlreadyExistException extends EnglishSystemException {

    public WordAlreadyExistException(String word) {
        super("單字 " + word + " 已存在");
    }
}
