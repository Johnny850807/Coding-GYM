package exceptions;

/**
 * @author - wally55077@gmail.com
 */
public class AddWordFailedException extends EnglishSystemException {

    public AddWordFailedException(String word) {
        super("單字 " + word + " 加入失敗");
    }
}
