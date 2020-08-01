package Monster;


import monsterSkill.Summon;
import rpg.RpgSystem;

public class Boss extends Monster {

    public Boss(RpgSystem rpg) {
        super.setName("Boss");
        super.setHp(1000);
        super.setMp(300);
        super.setAtk(90);
        super.setDef(40);
        super.setMdf(40);
        super.setRpg(rpg);
        super.setSkill(new Summon(rpg));
    }
}
