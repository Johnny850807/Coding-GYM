package Monsters;

import Skill.Summon;
import rpg.Role;
import rpg.RpgSystem;


public class Boss extends Role {

    public Boss(RpgSystem rpg) {
        super.setName("Boss");
        super.setHp(1000);
        super.setMp(300);
        super.setAtk(90);
        super.setDef(40);
        super.setMdf(40);
        super.setRpg(rpg);
        super.getSkills().add(new Summon(rpg));
    }
}
