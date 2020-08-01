package Monsters;


import rpg.Role;

public class Soldier extends Role {

    public Soldier() {
        super.setName("士兵");
        super.setHp(150);
        super.setMp(0);
        super.setAtk(60);
        super.setDef(10);
        super.setMdf(0);
    }

}
