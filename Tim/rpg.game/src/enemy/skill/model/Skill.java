package enemy.skill.model;

import role.model.Round;

abstract public class Skill {
    private int mp;
    private int physicalInjureValue;
    private int magicInjureValue;

    public abstract boolean use(Round round);

    public int getMp() {
        return mp;
    }

    public int getPhysicalInjureValue() {
        return physicalInjureValue;
    }

    public int getMagicInjureValue() {
        return magicInjureValue;
    }

}
