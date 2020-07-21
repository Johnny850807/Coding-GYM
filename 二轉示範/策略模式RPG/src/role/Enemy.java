package role;

import skills.Skill;

import java.util.List;
import java.util.Random;

import static utils.Delay.delay;

/**
 * @author johnny850807@gmail.com (Waterball))
 */
public class Enemy extends Role {
    Random random = new Random();

    public Enemy(String name, Capability capability, Skill... skills) {
        super(name, capability, skills);
    }

    @Override
    public void makeMoveDecision() {
        delay(400);
        List<Skill> availableSkills = getAvailableSkills();
        useSkill(random.nextInt(availableSkills.size()));
    }

    @Override
    public Role makeTargetDecision(List<Role> targets) {
        delay(400);
        return targets.get(random.nextInt(targets.size()));
    }
}
