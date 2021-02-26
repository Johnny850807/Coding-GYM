package player.skill.model;

import enemy.skill.model.Skill;
import role.model.Player;
import role.model.Round;

/**
 * 強化自身
 * 消耗40點MP、提高自身防禦力30
 */
public class AddDefenseSkill extends Skill {
    private int mp = 40;
    private int addDefenseValue = 30;

    @Override
    public boolean use(Round round) {
        System.out.print("使用強化自身 ");
        Player player = round.getPlayer();
        if (player.isMpUseAble(mp)) {
            player.useMp(mp);
            player.plusDfValue(addDefenseValue);
            System.out.print("成功 並且 消耗"+mp+"點MP、提高自身防禦力"+addDefenseValue);
            return true;
        } else {
            return false;
        }
    }
}
