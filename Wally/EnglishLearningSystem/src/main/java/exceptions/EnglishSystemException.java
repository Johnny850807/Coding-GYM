package exceptions;

import lombok.NoArgsConstructor;

/**
 * @author - wally55077@gmail.com
 */
@NoArgsConstructor
public class EnglishSystemException extends RuntimeException {

    public EnglishSystemException(String message) {
        super(message);
    }
}
