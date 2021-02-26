package player.skill.model;

import enemy.skill.model.Skill;
import role.model.Round;

public class WaterBallSkill extends Skill {
    private int mp = 50;
    private int abilityPowerValue = 50;
    private SkillOfPlayer skillOfPlayer;

    public WaterBallSkill() {
        this.skillOfPlayer = SkillOfPlayer.WATERBALL;
    }

    @Override
    public boolean use(Round round) {
        System.out.println("技能發動:" + this.skillOfPlayer.getName() + "(" + this.skillOfPlayer.getDesc() + ")");
        if (round.getPlayer().isMpUseAble(mp)) {
            round.getPlayer().useMp(mp);
            round.areaOfEffect(abilityPowerValue);
            return true;
        } else {
            return false;
        }
    }
}
