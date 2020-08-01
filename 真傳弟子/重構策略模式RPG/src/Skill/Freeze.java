package Skill;

import rpg.Role;

public class Freeze extends Skill {
    public Freeze() {
        super.setConsumeMp(100);
        super.setName("結凍");
        super.setSkillDescribe("消耗100點MP、讓一個敵人無法行動3回合");
    }


    @Override
    public int skillAttack(Role attack , Role attacked) {
        System.out.println("玩家冰凍了" + attacked.getName() + "三回合");

        attack.setMp(attack.getMp() - super.getConsumeMp());
        attacked.setAction(false);
        attacked.setActionCount(attacked.getActionCount() + 3);

        return 0;
    }
}
