package HeroSkill;


import Monster.Monster;
import rpg.Hero;
import rpg.RpgSystem;

public class Freeze implements HeroSkill {
    private int consumeMp;
    private String skillDescribe;
    private String name;
    private RpgSystem rpg;

    public Freeze(RpgSystem rpg) {
        this.consumeMp = 100;
        this.name = "結凍";
        this.rpg = rpg;
        this.skillDescribe = "消耗100點MP、讓一個敵人無法行動3回合";
    }


    @Override
    public int skillAttack(Hero hero, Monster attacked) {
        System.out.println("玩家冰凍了" + attacked.getName() + "三回合");

        hero.setMp(hero.getMp() - consumeMp);
        attacked.setAction(false);
        attacked.setActionCount(attacked.getActionCount() + 3);

        return 0;
    }

    public int getConsumeMp() {
        return consumeMp;
    }

    @Override
    public String getName() {
        return name;
    }

    public String getSkillDescribe() {
        return skillDescribe;
    }
}
