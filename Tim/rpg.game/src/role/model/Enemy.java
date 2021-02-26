package role.model;

import enemy.skill.model.Skill;

public abstract class Enemy extends Role {

    protected Skill skill;

    public Enemy(String name, int hp, int mp, int ap, int df, int mdf) {
        super(name, hp, mp, ap, df, mdf);
    }

    @Override
    public void showStatus() {
        super.showStatus();
    }

    @Override
    abstract public void action(Round round);

    public void setSkill(Skill skill) {
        this.skill = skill;
    }
}
