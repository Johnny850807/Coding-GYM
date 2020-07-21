package skills;

import battle.Battle;
import role.Role;
import role.status.Frozen;

/**
 * @author johnny850807@gmail.com (Waterball))
 */
public class 凍結 extends AbstractSkill {
    @Override
    public void effect(Role skillOwner, Battle battle) {
        Role target = skillOwner.makeTargetDecision(battle.getOpponents());
        super.effect(skillOwner, battle);
        System.out.printf("目標為 %s！三回合不能移動！", target.getName());
        target.setStatus(new Frozen(3, target));
    }

    @Override
    public String getName() {
        return getClass().getSimpleName();
    }

    @Override
    public int getRequiredMP() {
        return 100;
    }
}
