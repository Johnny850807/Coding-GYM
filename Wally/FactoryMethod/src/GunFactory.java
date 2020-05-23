import Bullet.ExplosionBullet;
import Bullet.MachineBullet;
import Bullet.SniperBullet;

public abstract class GunFactory {

    public static Gun generateGun(GunType gunType) {
        switch (gunType) {
            case MACHINE_GUN:
                return new MachineGun(new MachineBullet());
            case SHOTGUN:
                return new ShotGun(new ExplosionBullet());
            case SNIPER:
                return new Shiper(new SniperBullet());
            default:
                throw new RuntimeException("Wrong gun type");
        }
    }
}
