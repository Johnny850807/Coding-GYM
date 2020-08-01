package Skill;


import rpg.Role;

public class StrengthenBody extends Skill {

    public StrengthenBody() {
        super.setConsumeMp(40);
        super.setName("強化自身");
        super.setSkillDescribe("消耗40點MP、提高自身防禦力30");
    }

    @Override
    public int skillAttack(Role attack , Role attacked) {
        attack.setMp(attack.getMp() - super.getConsumeMp());
        attack.setDef(attack.getDef() + 30);
        System.out.println("玩家防禦力提高了30");
        return 0;
    }

}
