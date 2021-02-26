package role.model;

import enemy.skill.model.NormalAttack;

public class Guard extends Enemy {

    public Guard() {
        super("護衛隊", 270, 0, 100, 20, 40);
        skill = new NormalAttack();
    }

    @Override
    public void showStatus() {
        super.showStatus();
    }

    @Override
    public void action(Round round) {
        skill.use(round);
    }
}
