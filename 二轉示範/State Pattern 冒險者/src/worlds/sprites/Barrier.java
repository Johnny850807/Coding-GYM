package worlds.sprites;

import worlds.sprites.states.NoAction;

/**
 * @author johnny850807@gmail.com (Waterball))
 */
public class Barrier extends AbstractSprite {
    public Barrier(int x, int y) {
        super(x, y, Integer.MAX_VALUE, "障礙物");
        setState(new NoAction(this));
    }

    @Override
    public void doDamaged(int damage) {
        /* do nothing, must not die */
    }

    @Override
    public void performAttack() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void decideAction() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void collide(Sprite sprite) { }

    @Override
    public Direction decideDirection(Direction... directions) {
        throw new UnsupportedOperationException();
    }

    @Override
    public char getSymbol() {
        return '□';
    }
}
