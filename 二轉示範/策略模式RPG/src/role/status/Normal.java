package role.status;

import role.Role;
import skills.Skill;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author johnny850807@gmail.com (Waterball))
 */
public class Normal extends AbstractStatus {

    public Normal(Role role) {
        super(role);
    }

    @Override
    public void move() {
        role.makeMoveDecision();
    }

    @Override
    public void useSkill(int skillNumber) {
        role.getSkills()[skillNumber].effect(role, role.getBattle());
    }

    @Override
    public int doDamage(int damage) {
        int actualDamage = Math.max(damage - role.getDefence(), 0);
        role.lostHp(actualDamage);
        return actualDamage;
    }

    @Override
    public int doMagicDamage(int magicDamage) {
        int actualDamage = Math.max(magicDamage - role.getMagicDefence(), 0);
        role.lostHp(actualDamage);
        return actualDamage;
    }

    @Override
    public List<Skill> getAvailableSkills() {
        return Arrays.stream(role.getSkills())
                .filter(s -> s.getRequiredMP() <= role.getMp())
                .collect(Collectors.toList());
    }
}
