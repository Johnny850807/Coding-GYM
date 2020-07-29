package worlds.sprites.states;

import worlds.sprites.SpriteStateOwner;

/**
 * @author johnny850807@gmail.com (Waterball))
 */
public class Explosion extends ExpiryState {

    public Explosion(SpriteStateOwner owner) {
        super(owner, "爆發", 3);
    }

    @Override
    public void onAttackDecisionMade() {
        getWorld().getAllSprites()
                .forEach(s -> s.onBeingAttackedBy(owner, 50));
    }

    @Override
    protected State nextStateAfterExpiry() {
        return new Teleportation(owner);
    }
}
