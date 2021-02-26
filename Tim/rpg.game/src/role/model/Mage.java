package role.model;

import enemy.skill.model.LightningSpellAttack;
import enemy.skill.model.NormalAttack;

public class Mage extends Enemy {

    public Mage() {
        super("法師", 90, 700, 5, 20, 60);
        skill = new LightningSpellAttack();
    }

    @Override
    public void showStatus() {
        super.showStatus();
    }

    @Override
    public void action(Round round) {
        if (!skill.use(round)) {
            setSkill(new NormalAttack());
            skill.use(round);
        }
    }
}
