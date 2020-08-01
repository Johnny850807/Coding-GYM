package Skill;


import rpg.Role;
import rpg.RpgSystem;


public class WaterBall extends Skill {

    public WaterBall(RpgSystem rpg) {
        super.setConsumeMp(50);
        super.setName("水球攻擊");
        super.setRpg(rpg);
        super.setSkillDescribe("消耗50點MP、一次攻擊所有怪物，魔法傷害值 50");

    }

    @Override
    public int skillAttack(Role attack , Role attacked) {
        int damage = 0;

        attack.setMp(attack.getMp() - super.getConsumeMp());
        for (Role monster : super.getRpg().getMonsters()) {
            if (50 - monster.getMdf() >= 0) {
                damage += 50 - monster.getMdf();
                monster.setHp(monster.getHp() - (50- monster.getMdf()));
            }
        }

        return damage;
    }

}
