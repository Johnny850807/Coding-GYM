package Skill;


import rpg.Role;
import rpg.RpgSystem;



public class Lightning extends Skill {

    public Lightning(RpgSystem rpg) {
        super.setName("雷擊");
        super.setConsumeMp(100);
        super.setSkillDescribe("雷擊：消耗100點MP、造成魔法傷害250點");
    }

    @Override
    public int skillAttack(Role attack , Role attacked) {
        int damage = 0;

        if (attack.getMp() > super.getConsumeMp()) {
            attack.setMp(attack.getMp() - super.getConsumeMp());
            System.out.println("[怪物]" + attack.getName() + "使用了" + super.getName());
            damage = 250 - attacked.getMdf();
            if (damage > 0) {
                attacked.setHp(attacked.getHp() - damage);
                return damage;
            }
        }
        return super.getRpg().normalAttack(attack, attacked);
    }

}
