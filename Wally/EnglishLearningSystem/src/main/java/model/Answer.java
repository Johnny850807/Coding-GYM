package model;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author - wally55077@gmail.com
 */
@Data
@AllArgsConstructor
public class Answer {
    private String word = "";

    public boolean match(String answer) {
        return this.word.equalsIgnoreCase(answer);
    }
}
