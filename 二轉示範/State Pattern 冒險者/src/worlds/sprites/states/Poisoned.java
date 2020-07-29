package worlds.sprites.states;

import worlds.sprites.SpriteStateOwner;

/**
 * @author johnny850807@gmail.com (Waterball))
 */
public class Poisoned extends ExpiryState {
    public Poisoned(SpriteStateOwner owner) {
        super(owner, "中毒", 3);
    }

    @Override
    public void onTurnBegins() {
        System.out.println(" -- [中毒] --");
        owner.doDamaged(15);
        super.onTurnBegins();
    }
}
