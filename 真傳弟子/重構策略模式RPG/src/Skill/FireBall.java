package Skill;


import rpg.Role;

public class FireBall extends Skill {

    public FireBall() {
        super.setConsumeMp(50);
        super.setName("火球術");
        super.setSkillDescribe("消耗50點MP、攻擊一隻怪物，魔法傷害值 150");
    }

    @Override
    public int skillAttack(Role attack , Role attacked) {
        attack.setMp(attack.getMp() - super.getConsumeMp());
        int damage = 150 - attacked.getMdf();
        if (damage >= 0) {
            attacked.setHp(attacked.getHp() - damage);
            return damage;
        }
        return 0;
    }

}
