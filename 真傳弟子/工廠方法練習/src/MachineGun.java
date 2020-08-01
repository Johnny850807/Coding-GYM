import Bullet.Bullet;
import Bullet.MachineBullet;

public class MachineGun implements Gun {
    @Override
    public Bullet attack() {
        return new MachineBullet();
    }
}
