package worlds.sprites.states;

import worlds.sprites.Sprite;
import worlds.sprites.SpriteStateOwner;

/**
 * @author johnny850807@gmail.com (Waterball))
 */
public class EnergySaving extends ExpiryState {
    public EnergySaving(SpriteStateOwner owner) {
        super(owner, "蓄力", 2);
    }

    @Override
    public void onBeingAttackedBy(Sprite sprite, int damage) {
        System.out.println("遭受攻擊，取消蓄力狀態...");
        super.onBeingAttackedBy(sprite, damage);
    }

    @Override
    protected State nextStateAfterExpiry() {
        return new Explosion(owner);
    }
}
