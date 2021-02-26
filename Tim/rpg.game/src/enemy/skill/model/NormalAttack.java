package enemy.skill.model;

import role.model.Enemy;
import role.model.Player;
import role.model.Round;

import java.util.Optional;

public class NormalAttack extends Skill {

    @Override
    public boolean use(Round round) {
        Optional<Enemy> optionalEnemy = round.getEnemies().stream().filter(r -> r.isTurnMe()).findAny();
        Enemy enemy = optionalEnemy.get();
        Player player = round.getPlayer();
        System.out.println("       使用 普通攻擊(" + enemy.getAp() + ") 請選擇攻擊目標:" + player.getName());
        int hurtValue = enemy.getAp() - player.getDf();
        if (hurtValue < 0) {
            System.out.println("       防禦抵銷(" + player.getDf() + ")， 後直接傷害。(0)");
        } else {
            System.out.println("       防禦抵銷(" + player.getDf() + ")， 後直接傷害。(" + hurtValue + ")");
            player.useHp(hurtValue);
            System.out.println("       攻擊目標狀態:" + player.toString());
        }

        return true;
    }

}
