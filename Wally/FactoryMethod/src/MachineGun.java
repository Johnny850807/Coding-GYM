import Bullet.Bullet;
import Bullet.MachineBullet;

public class MachineGun extends Gun {

    @Override
    public Bullet fire() {
        return new MachineBullet();
    }
}
