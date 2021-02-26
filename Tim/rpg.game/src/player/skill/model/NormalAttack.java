package player.skill.model;

import enemy.skill.model.Skill;
import role.model.Enemy;
import role.model.Player;
import role.model.Round;

public class NormalAttack extends Skill {

    @Override
    public boolean use(Round round) {
        Player player = round.getPlayer();
        Enemy enemy = round.findIndexByEnemey();
        System.out.println("       使用 普通攻擊(" + player.getAp() + ") 請選擇攻擊目標:" + enemy.getName());
        int hurtValue = player.getAp() - enemy.getDf();
        if (hurtValue < 0) {
            System.out.println("       防禦抵銷(" + player.getDf() + ")， 後直接傷害。(0)");
        } else {
            enemy.useHp(hurtValue);
            System.out.println(" 攻擊目標狀態:" + enemy.toString());
        }
        return true;
    }
}
