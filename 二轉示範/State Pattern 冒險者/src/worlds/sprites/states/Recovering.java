package worlds.sprites.states;

import worlds.sprites.SpriteStateOwner;

/**
 * @author johnny850807@gmail.com (Waterball))
 */
public class Recovering extends ExpiryState {
    public Recovering(SpriteStateOwner owner) {
        super(owner, "恢復", 5);
    }

    @Override
    public void onTurnBegins() {
        System.out.println(" -- [恢復] --");
        owner.doRecoverHp(30);
        if (owner.getHp() == owner.getMaxHp()) {
            System.out.println("滿血，恢復狀態停止。");
            owner.setState(new Normal(owner));
        }
        super.onTurnBegins();
    }
}
