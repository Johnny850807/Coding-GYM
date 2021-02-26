package player.skill.model;

import enemy.skill.model.Skill;
import role.model.Enemy;
import role.model.FreezeSkillExtraDamage;
import role.model.Player;
import role.model.Round;

import java.util.List;

public class FreezeSkill extends Skill {
    private int mp = 100;
    private SkillOfPlayer skillOfPlayer;

    public FreezeSkill() {
        this.skillOfPlayer = SkillOfPlayer.FREEZE;
    }

    //消耗100點MP、讓一個敵人無法行動3回合
    public boolean use(Round round) {
        System.out.println("技能發動:" + this.skillOfPlayer.getName() + "(" + this.skillOfPlayer.getDesc() + ")");
        Player player = round.getPlayer();
        if (player.isMpUseAble(mp)) {
            player.useMp(mp);
            Enemy enemy = round.findIndexByEnemey();
            enemy.getExtraStatus().add(new FreezeSkillExtraDamage());
            return true;
        }
        return false;
    }
}
