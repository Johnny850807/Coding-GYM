package Gun;

import Bullet.*;

public interface Gun {
	Bullet createBullet();
	int getDamage();
}
