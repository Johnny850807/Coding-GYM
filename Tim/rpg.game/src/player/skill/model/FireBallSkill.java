package player.skill.model;

import enemy.skill.model.Skill;
import role.model.Enemy;
import role.model.Player;
import role.model.Round;

public class FireBallSkill extends Skill {
    private int mp = 50;
    private int abilityPowerValue = 150;
    private final SkillOfPlayer skillOfPlayer;

    public FireBallSkill() {
        this.skillOfPlayer = SkillOfPlayer.FIREBALL;
    }

    public boolean use(Round round) {
        Player player = round.getPlayer();
        System.out.println("技能發動:" + this.skillOfPlayer.getName() + "(" + this.skillOfPlayer.getDesc() + ")");
        if (player.isMpUseAble(mp)) {
            player.useMp(mp);
            Enemy enemy = round.findIndexByEnemey();
            enemy.useHp(abilityPowerValue - enemy.getMdf());
            return true;
        }
        return false;
    }
}
