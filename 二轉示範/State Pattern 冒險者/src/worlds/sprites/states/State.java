package worlds.sprites.states;

import worlds.World;
import worlds.sprites.SpriteState;
import worlds.sprites.SpriteStateOwner;

/**
 * @author johnny850807@gmail.com (Waterball))
 */
public abstract class State implements SpriteState {
    protected SpriteStateOwner owner;
    protected String name;

    public State(SpriteStateOwner owner, String name) {
        this.owner = owner;
        this.name = name;
    }

    protected World getWorld() {
        return owner.getWorld();
    }

    public String getName() {
        return name;
    }
}
