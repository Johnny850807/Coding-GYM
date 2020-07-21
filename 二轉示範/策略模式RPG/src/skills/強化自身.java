package skills;

import battle.Battle;
import role.Role;

/**
 * @author johnny850807@gmail.com (Waterball))
 */
public class 強化自身 extends AbstractSkill {
    @Override
    public void effect(Role skillOwner, Battle battle) {
        super.effect(skillOwner, battle);
        skillOwner.setDefence(skillOwner.getDefence() + 30);
        System.out.println("防禦力加 30。");
    }

    @Override
    public String getName() {
        return getClass().getSimpleName();
    }

    @Override
    public int getRequiredMP() {
        return 40;
    }
}
