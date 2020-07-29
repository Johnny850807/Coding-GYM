package worlds.sprites.states;

import worlds.sprites.SpriteStateOwner;

/**
 * @author johnny850807@gmail.com (Waterball))
 */
public abstract class ExpiryState extends Normal {
    private boolean initiated = false;
    private int duration;

    public ExpiryState(SpriteStateOwner owner, String name, int duration) {
        super(owner, name);
        this.duration = duration;
    }

    @Override
    public void onTurnEnds() {
        super.onTurnEnds();
        if (initiated) {
            if (--duration <= 0) {
                onStateExpired();
                owner.setState(nextStateAfterExpiry());
            }
        } else {
            initiated = true;
        }
    }

    @Override
    public String getName() {
        return String.format("%s:<%d回合>", super.getName(), duration);
    }

    protected void onStateExpired() { }

    protected State nextStateAfterExpiry() {
        return new Normal(owner);
    }
}
