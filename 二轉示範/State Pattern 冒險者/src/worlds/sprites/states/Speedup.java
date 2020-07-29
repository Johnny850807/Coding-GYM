package worlds.sprites.states;

import worlds.sprites.Sprite;
import worlds.sprites.SpriteStateOwner;

/**
 * @author johnny850807@gmail.com (Waterball))
 */
public class Speedup extends ExpiryState {
    private int turnCountdown;
    public Speedup(SpriteStateOwner owner) {
        super(owner, "加速", 3);
    }


    @Override
    public void onTurnBegins() {
        if (turnCountdown <= 0) {
            System.out.println(" -- [加速] --");
            turnCountdown = 2;
        }
        super.onTurnBegins();
    }

    @Override
    public void onBeingAttackedBy(Sprite sprite, int damage) {
        super.onBeingAttackedBy(sprite, damage);
        turnCountdown = 0;
        System.out.println("遭受攻擊，取消加速狀態...");
        owner.setState(new Normal(owner));
    }

    @Override
    public void onTurnEnds() {
        super.onTurnEnds();
        turnCountdown --;

        if (turnCountdown > 0) {
            System.out.println("由於加速狀態，還具有一次執行機會。");
            getWorld().printMap();
            this.onTurnBegins();  // the second turn
        }
    }
}
