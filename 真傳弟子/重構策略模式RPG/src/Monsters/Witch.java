package Monsters;


import Skill.Lightning;
import rpg.Role;
import rpg.RpgSystem;


public class Witch extends Role {

    public Witch(RpgSystem rpg) {
        super.setName("法師");
        super.setHp(90);
        super.setMp(700);
        super.setAtk(5);
        super.setDef(20);
        super.setMdf(60);
        super.setRpg(rpg);
        super.getSkills().add(new Lightning(rpg));
    }

}
