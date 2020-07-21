package skills;

import battle.Battle;
import role.Role;

/**
 * @author johnny850807@gmail.com (Waterball))
 */
public abstract class AbstractSkill implements Skill {
    @Override
    public void effect(Role skillOwner, Battle battle) {
        skillOwner.consumeMp(getRequiredMP());
        System.out.printf("%s 使用了 %s！\n", skillOwner.getName(), this.getName());
    }

}
