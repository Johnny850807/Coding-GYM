package battle;

import role.Capability;
import role.HumanHero;
import role.Enemy;
import skills.*;

import static role.RoleFactory.*;

/**
 * @author johnny850807@gmail.com (Waterball))
 */
public class Main {
    public static void main(String[] args) {
        HumanHero humanHero = new HumanHero("英雄",
                new Capability(500, 500, 70, 40, 10),
                new 普通攻擊(), new 水球(), new 火球(), new 強化自身(), new 凍結());

        Battle[] battles = {
                new Battle(humanHero,
                        createSoldier(), createSoldier(), createSoldier(), createSoldier(), createGuard()),
                new Battle(humanHero,
                        createSoldier(), createSoldier(), createMage(), createMage()),
                new Battle(humanHero, createBoss())
        };

        for (Battle battle : battles) {
            battle.startBattle();
        }

        System.out.println("恭喜！遊戲勝利！");
    }

}
