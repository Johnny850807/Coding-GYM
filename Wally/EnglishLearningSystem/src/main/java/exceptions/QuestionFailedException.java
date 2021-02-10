package exceptions;

/**
 * @author - wally55077@gmail.com
 */
public class QuestionFailedException extends EnglishSystemException {
    public QuestionFailedException(String originWord) {
        super(originWord);
    }
}
