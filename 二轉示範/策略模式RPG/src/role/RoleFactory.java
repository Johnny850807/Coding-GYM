package role;

import skills.召喚;
import skills.普通攻擊;
import skills.雷擊;

/**
 * @author johnny850807@gmail.com (Waterball))
 */
public class RoleFactory {

    public static Enemy createSoldier() {
        return new Enemy("士兵", new Capability(150, 0, 60, 10, 0), new 普通攻擊());
    }

    public static Enemy createGuard() {
        return new Enemy("護衛隊", new Capability(270, 0, 100, 20, 40), new 普通攻擊());
    }

    public static Enemy createMage() {
        return new Enemy("法師", new Capability(90, 700, 5, 20, 60),
                new 普通攻擊(), new 雷擊());
    }

    public static Enemy createBoss() {
        return new Enemy("BOSS", new Capability(1000, 300, 90, 40, 40),
                new 普通攻擊(), new 召喚());
    }
}
