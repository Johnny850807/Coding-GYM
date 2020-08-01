import Bullet.Bullet;
import Bullet.SniperBullet;

public class SniperGun implements Gun {
    @Override
    public Bullet attack() {
        return new SniperBullet();
    }

}
