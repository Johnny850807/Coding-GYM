package worlds.sprites.states;

import worlds.sprites.Direction;
import worlds.sprites.SpriteStateOwner;

import java.util.Random;

/**
 * @author johnny850807@gmail.com (Waterball))
 */
public class Chaotic extends ExpiryState {
    private static final Random random = new Random();
    private Direction[] candidateDirections;

    public Chaotic(SpriteStateOwner owner) {
        super(owner, "混亂", 3);
    }

    @Override
    public void onTurnBegins() {
        System.out.println(" -- [混亂] --");
        candidateDirections = random.nextBoolean() ?
                new Direction[]{Direction.UP, Direction.DOWN} : new Direction[]{Direction.LEFT, Direction.RIGHT};
        super.onTurnBegins();
    }

    @Override
    public void onMoveForwardDecisionMade() {
        Direction direction = owner.decideDirection(candidateDirections);
        owner.setDirection(direction);
        getWorld().moveSpriteForward(owner);
    }
}
