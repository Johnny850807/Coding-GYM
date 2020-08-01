package HeroSkill;


import Monster.Monster;
import rpg.Hero;
import rpg.RpgSystem;

public class StrengthenBody implements HeroSkill {
    private int consumeMp;
    private String skillDescribe;
    private String name;
    private RpgSystem rpg;


    public StrengthenBody(RpgSystem rpg) {
        this.consumeMp = 40;
        this.rpg = rpg;
        this.name = "強化自身";
        this.skillDescribe = "消耗40點MP、提高自身防禦力30";
    }

    @Override
    public int skillAttack(Hero hero, Monster attacked) {
        hero.setMp(hero.getMp() - consumeMp);
        rpg.getHero().setDef(rpg.getHero().getDef() + 30);
        System.out.println("玩家防禦力提高了30");
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
