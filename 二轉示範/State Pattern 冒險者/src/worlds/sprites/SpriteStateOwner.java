package worlds.sprites;

/**
 * @author johnny850807@gmail.com (Waterball))
 */
public interface SpriteStateOwner extends Sprite {
    void performAttack();
    void decideAction();
    void doRecoverHp(int recover);
    void doDamaged(int damage);
    void collide(Sprite sprite);
    Direction decideDirection(Direction... directions);
}
