import Bullet.Bullet;
import Bullet.ExplosionBullet;

public class ShotGun extends Gun {

    @Override
    public Bullet fire() {
        return new ExplosionBullet();
    }
}
