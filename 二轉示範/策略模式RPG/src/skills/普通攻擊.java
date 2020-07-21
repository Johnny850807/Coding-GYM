package skills;

import battle.Battle;
import role.Role;

/**
 * @author johnny850807@gmail.com (Waterball))
 */
public class 普通攻擊 extends AbstractSkill {
    @Override
    public void effect(Role skillOwner, Battle battle) {
        Role target = skillOwner.makeTargetDecision(battle.getOpponents());
        int actualDamage = target.doDamage(skillOwner.getAttackPoint());
        super.effect(skillOwner, battle);
        System.out.printf("選擇的攻擊對象為 %s！造成了 %d點傷害。\n", target.getName(), actualDamage);
    }

    @Override
    public String getName() {
        return getClass().getSimpleName();
    }

    @Override
    public int getRequiredMP() {
        return 0;
    }
}
