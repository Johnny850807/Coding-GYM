package worlds.sprites.states;

import worlds.sprites.Direction;
import worlds.sprites.Sprite;
import worlds.sprites.SpriteStateOwner;

/**
 * @author johnny850807@gmail.com (Waterball))
 */
public class Normal extends State {
    public Normal(SpriteStateOwner owner) {
        super(owner, "正常");
    }

    public Normal(SpriteStateOwner owner, String name) {
        super(owner, name);
    }

    @Override
    public boolean canMove() {
        return true;
    }

    @Override
    public void onTurnBegins() {
        if (canMove()) {
            owner.decideAction();
        }
    }

    @Override
    public void onMoveForwardDecisionMade() {
        Direction direction = owner.decideDirection(Direction.values());
        owner.setDirection(direction);
        getWorld().moveSpriteForward(owner);
    }

    @Override
    public void onAttackDecisionMade() {
        owner.performAttack();
    }

    @Override
    public void onBeingAttackedBy(Sprite sprite, int damage) {
        owner.doDamaged(damage);
    }

    @Override
    public void onCollisionWith(Sprite sprite) {
        owner.collide(sprite);
    }

    @Override
    public void onTurnEnds() {

    }
}
