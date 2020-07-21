package skills;

import battle.Battle;
import role.Role;

/**
 * @author johnny850807@gmail.com (Waterball))
 */
public interface Skill {
    void effect(Role skillOwner, Battle battle);

    String getName();

    int getRequiredMP();
}
