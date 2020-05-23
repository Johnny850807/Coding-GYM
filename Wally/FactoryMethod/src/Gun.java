import Bullet.Bullet;

public abstract class Gun {

    private Bullet bullet;

    public Gun(Bullet bullet) {
        this.bullet = bullet;
    }

    public int fire() {
        return bullet.getSumDamage();
    }
}
