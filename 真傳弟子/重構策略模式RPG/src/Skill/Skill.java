package Skill;

import rpg.Role;
import rpg.RpgSystem;



public abstract class Skill {
    private int consumeMp;
    private String skillDescribe;
    private String name;
    private RpgSystem rpg;

    public abstract int skillAttack(Role attack, Role attacked);

    public int getConsumeMp() {
        return consumeMp;
    }

    public void setConsumeMp(int consumeMp) {
        this.consumeMp = consumeMp;
    }

    public String getSkillDescribe() {
        return skillDescribe;
    }

    public void setSkillDescribe(String skillDescribe) {
        this.skillDescribe = skillDescribe;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public RpgSystem getRpg() {
        return rpg;
    }

    public void setRpg(RpgSystem rpg) {
        this.rpg = rpg;
    }

}
