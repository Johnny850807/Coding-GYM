package Monster;


import monsterSkill.Lightning;
import rpg.RpgSystem;

public class Witch extends Monster {

    public Witch(RpgSystem rpg) {
        super.setName("法師");
        super.setHp(90);
        super.setMp(700);
        super.setAtk(5);
        super.setDef(20);
        super.setMdf(60);
        super.setRpg(rpg);
        super.setSkill(new Lightning(rpg));
    }

}
