package role.status;

import skills.Skill;

import java.util.List;

/**
 * @author johnny850807@gmail.com (Waterball))
 */
public interface Status {
    void move();

    void useSkill(int skillNumber);

    int doDamage(int damage);

    int doMagicDamage(int magicDamage);

    List<Skill> getAvailableSkills();
}
