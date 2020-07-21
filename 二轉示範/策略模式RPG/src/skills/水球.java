package skills;

import battle.Battle;
import role.Role;

import static utils.Delay.delay;

/**
 * @author johnny850807@gmail.com (Waterball))
 */
public class 水球 extends AbstractSkill {
    @Override
    public void effect(Role skillOwner, Battle battle) {
        super.effect(skillOwner, battle);
        for (Role opponent : battle.getOpponents()) {
            delay(150);
            int actualDamage = opponent.doMagicDamage(50);
            System.out.printf("水球對 %s 造成了 %d點傷害。\n", opponent.getName(), actualDamage);
        }
    }

    @Override
    public String getName() {
        return getClass().getSimpleName();
    }

    @Override
    public int getRequiredMP() {
        return 50;
    }
}
