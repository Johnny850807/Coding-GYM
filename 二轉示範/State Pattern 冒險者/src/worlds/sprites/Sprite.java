package worlds.sprites;

import worlds.World;
import worlds.sprites.states.State;

/**
 * @author johnny850807@gmail.com (Waterball))
 */
public interface Sprite extends SpriteState {
    int getX();
    int getY();
    void setX(int x);
    void setY(int y);
    int getMaxHp();
    int getHp();
    char getSymbol();
    void setDirection(Direction direction);
    State getState();
    void setState(State state);
    World getWorld();
    void setWorld(World world);
    Direction getDirection();
    String getName();
    boolean isDead();
}
