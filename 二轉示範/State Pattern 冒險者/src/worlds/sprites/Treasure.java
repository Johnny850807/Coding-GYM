package worlds.sprites;

import worlds.Point;
import worlds.sprites.states.*;

import java.util.Collections;
import java.util.Stack;
import java.util.function.Consumer;

/**
 * 無敵星星	10%	獲得無敵狀態  2/20
 * 毒藥	25%	獲得中毒狀態   5/20
 * 加速藥水	20%	獲得加速狀態  4/20
 * 補血罐	15%	獲得恢復狀態  3/20
 * 惡魔果實	10%	獲得混亂狀態  2/20
 * 王者之印	10%	獲得蓄力狀態 2/20
 * 任意門	10%	獲得瞬身狀態 2/20
 *
 * @author johnny850807@gmail.com (Waterball))
 */
public class Treasure extends AbstractSprite {
    private final static Item SUPER_STAR = new Item("無敵星星", s -> s.setState(new Invincible(s)));
    private final static Item POISON = new Item("毒藥", s -> s.setState(new Poisoned(s)));
    private final static Item SPEEDUP_POTION = new Item("加速藥水", s -> s.setState(new Speedup(s)));
    private final static Item RECOVER_POTION = new Item("補血罐", s -> s.setState(new Recovering(s)));
    private final static Item DEVIL_FRUIT = new Item("惡魔果實", s -> s.setState(new Chaotic(s)));
    private final static Item KING_ROCK = new Item("王者之印", s -> s.setState(new EnergySaving(s)));
    private final static Item DOKODEMO_DOOR = new Item("任意門", s -> s.setState(new Teleportation(s)));

    private final static Stack<Item> candidateItems = new Stack<>();

    static {
        populateCandidateItems();
    }

    @SuppressWarnings("DuplicatedCode")
    private static void populateCandidateItems() {
        candidateItems.push(SUPER_STAR);
        candidateItems.push(SUPER_STAR);
        candidateItems.push(POISON);
        candidateItems.push(POISON);
        candidateItems.push(POISON);
        candidateItems.push(POISON);
        candidateItems.push(POISON);
        candidateItems.push(SPEEDUP_POTION);
        candidateItems.push(SPEEDUP_POTION);
        candidateItems.push(SPEEDUP_POTION);
        candidateItems.push(SPEEDUP_POTION);
        candidateItems.push(RECOVER_POTION);
        candidateItems.push(RECOVER_POTION);
        candidateItems.push(RECOVER_POTION);
        candidateItems.push(DEVIL_FRUIT);
        candidateItems.push(DEVIL_FRUIT);
        candidateItems.push(KING_ROCK);
        candidateItems.push(KING_ROCK);
        candidateItems.push(DOKODEMO_DOOR);
        candidateItems.push(DOKODEMO_DOOR);

        for (int i = 0; i < 3; i++) {
            Collections.shuffle(candidateItems);
        }
    }

    public Treasure(int x, int y) {
        super(x, y, Integer.MAX_VALUE, "寶藏");
    }

    @Override
    public void collide(Sprite sprite) {
        if (sprite instanceof SpriteStateOwner) {
            Item nextItem = candidateItems.pop();
            nextItem.applyTo((SpriteStateOwner) sprite);
            if (candidateItems.isEmpty()) {
                populateCandidateItems();
            }
        }
        getWorld().removeSprite(this);
    }

    @Override
    public boolean canMove() {
        return false;
    }

    private final static class Item {
        private String name;
        private Consumer<SpriteStateOwner> effect;

        public Item(String name, Consumer<SpriteStateOwner> effect) {
            this.name = name;
            this.effect = effect;
        }

        public void applyTo(SpriteStateOwner sprite) {
            System.out.println(sprite.getName() + " 使用了 " + name);
            effect.accept(sprite);
        }
    }

    @Override
    public void onBeingAttackedBy(Sprite sprite, int damage) {
        // the treasure won't be attacked
    }

    @Override
    public void performAttack() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void decideAction() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Direction decideDirection(Direction... directions) {
        throw new UnsupportedOperationException();
    }

    @Override
    public char getSymbol() {
        return '◆';
    }
}
