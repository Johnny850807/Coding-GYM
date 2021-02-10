package exceptions;

/**
 * @author - wally55077@gmail.com
 */
public class UpdateWordFailedException extends EnglishSystemException {
    public UpdateWordFailedException(String word) {
        super("單字 " + word + " 更改失敗");
    }
}
