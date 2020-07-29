package worlds.sprites;

import com.apple.eawt.AppEvent;
import worlds.World;
import worlds.sprites.states.Normal;
import worlds.sprites.states.State;

/**
 * @author johnny850807@gmail.com (Waterball))
 */
public abstract class AbstractSprite implements SpriteStateOwner {
    private World world;
    private int x;
    private int y;
    private int maxHp;
    private int hp;
    private Direction direction = Direction.DOWN;
    private String name;
    private State state = new Normal(this);

    public AbstractSprite(int x, int y, int hp, String name) {
        this.x = x;
        this.y = y;
        this.maxHp = this.hp = hp;
        this.name = name;
    }

    @Override
    public State getState() {
        return state;
    }

    @Override
    public void setState(State state) {
        this.state = state;
    }

    @Override
    public Direction getDirection() {
        return direction;
    }

    @Override
    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }

    public boolean isDead() {
        return getHp() <= 0;
    }

    public int getHp() {
        return hp;
    }

    public String getName() {
        return name;
    }

    @Override
    public World getWorld() {
        return world;
    }

    @Override
    public void setWorld(World world) {
        this.world = world;
    }

    @Override
    public int getMaxHp() {
        return maxHp;
    }

    @Override
    public void doRecoverHp(int recover) {
        recover = Math.max(recover, 0);
        System.out.println(getName() + "恢復了 " +recover+" 點生命值");
        this.hp = Math.min(this.maxHp, this.hp + recover);
    }

    @Override
    public void doDamaged(int damage) {
        System.out.println(getName() + "受到了 " +damage+" 點傷害值");
        hp = hp < damage ? 0 : hp - damage;
        if (hp <= 0) {
            System.out.println(getName() + " 死掉了");
            world.removeSprite(this);
        }
    }

    @Override
    public boolean canMove() {
        return world != null && state.canMove();
    }

    @Override
    public void onTurnBegins() {
        System.out.printf("輪到 %s 了 [%s] (HP: %d/%d)\n",  getName(), state.getName(), getHp(), getMaxHp());
        state.onTurnBegins();
    }

    @Override
    public void onMoveForwardDecisionMade() {
        state.onMoveForwardDecisionMade();
    }

    @Override
    public void onAttackDecisionMade() {
        state.onAttackDecisionMade();
    }

    @Override
    public void onBeingAttackedBy(Sprite sprite, int damage) {
        System.out.printf("%s 被 %s 攻擊 ...", this.getName(), sprite.getName());
        state.onBeingAttackedBy(sprite, damage);
    }

    @Override
    public void onCollisionWith(Sprite sprite) {
        state.onCollisionWith(sprite);
    }

    @Override
    public void onTurnEnds() {
        state.onTurnEnds();
    }

}
