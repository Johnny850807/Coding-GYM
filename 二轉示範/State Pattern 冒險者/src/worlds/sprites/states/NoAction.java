package worlds.sprites.states;

import worlds.sprites.Sprite;
import worlds.sprites.SpriteStateOwner;

/**
 * @author johnny850807@gmail.com (Waterball))
 */
public class NoAction extends State {
    public NoAction(SpriteStateOwner owner) {
        super(owner, "無");
    }

    @Override
    public boolean canMove() {
        return false;
    }

    @Override
    public void onTurnBegins() {
    }

    @Override
    public void onMoveForwardDecisionMade() {
    }

    @Override
    public void onAttackDecisionMade() {
    }

    @Override
    public void onBeingAttackedBy(Sprite sprite, int damage) {
    }

    @Override
    public void onCollisionWith(Sprite sprite) {

    }

    @Override
    public void onTurnEnds() {

    }
}
