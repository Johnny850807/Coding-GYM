package exceptions;

/**
 * @author - wally55077@gmail.com
 */
public class DeleteWordFailedException  extends EnglishSystemException {

    public DeleteWordFailedException(String word) {
        super("單字 " + word + " 刪除失敗");
    }

}
