package HeroSkill;

import Monster.Monster;
import rpg.Hero;
import rpg.RpgSystem;

public class FireBall implements HeroSkill {
    private int consumeMp;
    private String skillDescribe;
    private String name;
    private RpgSystem rpg;


    public FireBall(RpgSystem rpg) {
        this.consumeMp = 50;
        this.name = "火球術";
        this.rpg = rpg;
        this.skillDescribe = "消耗50點MP、攻擊一隻怪物，魔法傷害值 150";
    }

    @Override
    public int skillAttack(Hero hero, Monster attacked) {
        hero.setMp(hero.getMp() - consumeMp);
        int damage = 150 - attacked.getMdf();
        if (damage >= 0) {
            attacked.setHp(attacked.getHp() - damage);
            return damage;
        }
        return 0;
    }

    public int getConsumeMp() {
        return consumeMp;
    }

    @Override
    public String getSkillDescribe() {
        return skillDescribe;
    }

    @Override
    public String getName() {
        return name;
    }
}
