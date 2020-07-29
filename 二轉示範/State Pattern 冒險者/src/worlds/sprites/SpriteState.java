package worlds.sprites;

/**
 * @author johnny850807@gmail.com (Waterball))
 */
public interface SpriteState {
    boolean canMove();

    void onTurnBegins();

    void onMoveForwardDecisionMade();

    void onAttackDecisionMade();

    void onBeingAttackedBy(Sprite sprite, int damage);

    void onCollisionWith(Sprite sprite);

    void onTurnEnds();
}
