import Bullet.Bullet;
import Bullet.SniperBullet;

public class SniperRifle extends Gun {
    @Override
    public Bullet fire() {
        return new SniperBullet();
    }
}
