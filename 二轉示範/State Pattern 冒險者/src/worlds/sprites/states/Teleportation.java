package worlds.sprites.states;

import worlds.Point;
import worlds.sprites.SpriteStateOwner;

import java.util.List;
import java.util.Random;

/**
 * @author johnny850807@gmail.com (Waterball))
 */
public class Teleportation extends ExpiryState {
    private final static Random RANDOM = new Random();
    public Teleportation(SpriteStateOwner owner) {
        super(owner, "瞬身", 1);
    }

    @Override
    protected void onStateExpired() {
        List<Point> availablePoints = getWorld().getAvailablePoints();
        Point point = availablePoints.get(RANDOM.nextInt(availablePoints.size()));
        getWorld().teleport(owner, point.x, point.y);
        System.out.println(" -- [瞬深] --");
        System.out.printf("%s 瞬移到 (%d, %d)\n", owner.getName(), point.x, point.y);
    }
}
