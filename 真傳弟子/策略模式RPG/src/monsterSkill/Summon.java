package monsterSkill;

import Monster.Soldier;
import Monster.Witch;
import Monster.Guard;
import Monster.Monster;
import rpg.Hero;
import rpg.RpgSystem;

public class Summon implements MonsterSkill {
    private String describe;
    private String name;
    private RpgSystem rpg;
    private int consumeMp;


    public Summon(RpgSystem rpg) {
        this.rpg = rpg;
        this.name = "召喚";
        this.consumeMp = 50;
        this.describe = "召喚：消耗50點MP、場上增加一位敵人 (士兵、護衛隊 或 法師)";
    }

    @Override
    public int skillAttack(Monster attack, Hero attacked) {
        int damage = 0;

        if (attack.getMp() > consumeMp) {
            attack.setMp(attack.getMp() - consumeMp);
            int summon = (int) (Math.random() * 3);
            switch (summon) {
                case 0:
                    rpg.getMonsters().add(new Soldier());
                    break;
                case 1:
                    rpg.getMonsters().add(new Guard());
                    break;
                case 2:
                    rpg.getMonsters().add(new Witch(rpg));
                    break;
            }
            System.out.println(attack.getName() + "召喚了" + rpg.getMonsters().get(rpg.getMonsters().size() - 1).getName());
        } else {
            rpg.monsterNormalAttack(attack, attacked);
        }
        return 0;
    }


    @Override
    public String getName() {
        return name;
    }
}
