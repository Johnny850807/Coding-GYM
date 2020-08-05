package game;

import java.io.Serializable;

/**
 * @author johnny850807@gmail.com (Waterball))
 */
public interface GameCommand extends Serializable {
    void execute();
    void undo();
}
