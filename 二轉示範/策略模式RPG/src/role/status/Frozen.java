package role.status;

import role.Role;
import skills.Skill;

import java.util.Collections;
import java.util.List;

/**
 * @author johnny850807@gmail.com (Waterball))
 */
public class Frozen extends Normal {
    private int countDown = 3;

    public Frozen(int countDown, Role role) {
        super(role);
        this.countDown = countDown;
    }

    @Override
    public void move() {
        countDown --;
        if (countDown <= 0) {
            System.out.println("解凍，下回合能開始進行攻擊！");
            role.setStatus(new Normal(role));
        } else {
            System.out.printf("由於受到凍結攻擊，還要%d回合後才能進行攻擊。\n", countDown);
        }
    }

    @Override
    public void useSkill(int skillNumber) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<Skill> getAvailableSkills() {
        return Collections.emptyList();
    }
}
