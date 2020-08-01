package Skill;


import Monsters.Guard;
import Monsters.Soldier;
import Monsters.Witch;
import rpg.Role;
import rpg.RpgSystem;

public class Summon extends Skill {

    public Summon(RpgSystem rpg) {
        super.setConsumeMp(50);
        super.setName("召喚");
        super.setRpg(rpg);
        super.setSkillDescribe("召喚：消耗50點MP、場上增加一位敵人 (士兵、護衛隊 或 法師)");
    }

    @Override
    public int skillAttack(Role attack , Role attacked) {
        int damage = 0;

        if (attack.getMp() > super.getConsumeMp()) {
            attack.setMp(attack.getMp() - getConsumeMp());
            int summon = (int) (Math.random() * 3);
            switch (summon) {
                case 0:
                    getRpg().getMonsters().add(new Soldier());
                    break;
                case 1:
                    getRpg().getMonsters().add(new Guard());
                    break;
                case 2:
                    getRpg().getMonsters().add(new Witch(getRpg()));
                    break;
            }
            System.out.println(attack.getName() + "召喚了"
                    + getRpg().getMonsters().get(getRpg().getMonsters().size() - 1).getName());
        } else {
            getRpg().normalAttack(attack, attacked);
        }
        return 0;
    }

}
