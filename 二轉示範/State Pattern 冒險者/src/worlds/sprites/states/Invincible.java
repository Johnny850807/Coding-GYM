package worlds.sprites.states;

import worlds.sprites.Sprite;
import worlds.sprites.SpriteStateOwner;

/**
 * @author johnny850807@gmail.com (Waterball))
 */
public class Invincible extends Normal {
    public Invincible(SpriteStateOwner owner) {
        super(owner, "無敵");
    }

    @Override
    public void onBeingAttackedBy(Sprite sprite, int damage) {
        System.out.println(" -- [無敵] --");
        System.out.println(sprite.getName() + " 不會受到傷害");
    }
}
