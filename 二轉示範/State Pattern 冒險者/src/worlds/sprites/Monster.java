package worlds.sprites;

import worlds.World;
import worlds.sprites.states.Explosion;

import java.util.Collection;
import java.util.Random;

/**
 * @author johnny850807@gmail.com (Waterball))
 */
public class Monster extends AbstractSprite {
    private final static Random RANDOM = new Random();

    public Monster(int x, int y) {
        super(x, y, 1 /*can be killed by any single hit*/,  "怪物");
    }

    @Override
    public void performAttack() {
        System.out.println("選擇了向前攻擊！");
        getWorld().getSpriteInFrontOf(this)
                .ifPresent(s -> s.onBeingAttackedBy(this, 50));
    }

    @Override
    public void decideAction() {
        if (canMove()) {
            World world = getWorld();
            if (getState() instanceof Explosion ||
                    world.isFacingWithoutBarriersInBetween(this, world.getPlayer(), 1)) {
                onAttackDecisionMade();
            } else {
                onMoveForwardDecisionMade();
            }
        }
    }

    @Override
    public Direction decideDirection(Direction... directions) {
        Direction decision;
        Collection<Direction> availableDirections = getWorld().getAvailableDirections(this);
        decision = findFirstAvailableDirection(availableDirections, directions);
        System.out.println("選擇往"+decision+"走");
        return decision;
    }

    private Direction findFirstAvailableDirection(Collection<Direction> availableDirections, Direction[] directions) {
        for (Direction direction : directions) {
            if (availableDirections.contains(direction)) {
                return direction;
            }
        }
        return directions[RANDOM.nextInt(directions.length)]; // no available directions, arbitrarily move
    }

    @Override
    public void collide(Sprite sprite) { }

    @Override
    public char getSymbol() {
        return 'M';
    }
}
