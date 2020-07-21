package skills;

import battle.Battle;
import role.Role;
import role.RoleFactory;

import java.util.Base64;
import java.util.Random;

/**
 * @author johnny850807@gmail.com (Waterball))
 */
public class 召喚 extends AbstractSkill {
    private static final Random random = new Random();

    @Override
    public void effect(Role skillOwner, Battle battle) {
        super.effect(skillOwner, battle);
        int num = random.nextInt(3);
        Role summonedRole;
        switch (num) {
            case 0:
                summonedRole = RoleFactory.createSoldier();
                break;
            case 1:
                summonedRole = RoleFactory.createGuard();
                break;
            default:
                summonedRole =  RoleFactory.createMage();
                break;
        }
        battle.addAlly(summonedRole);
        System.out.printf("召喚了 %s！\n", summonedRole.getName());
    }

    @Override
    public String getName() {
        return "召喚";
    }

    @Override
    public int getRequiredMP() {
        return 50;
    }
}
