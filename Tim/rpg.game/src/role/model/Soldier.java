package role.model;

import enemy.skill.model.NormalAttack;

public class Soldier extends Enemy {

    public Soldier() {
        super("士兵", 150, 0, 60, 10, 0);
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
