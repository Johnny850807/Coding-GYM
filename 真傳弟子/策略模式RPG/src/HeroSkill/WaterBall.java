package HeroSkill;


import Monster.Monster;
import rpg.Hero;
import rpg.RpgSystem;

public class WaterBall implements HeroSkill {
    private int consumeMp;
    private String skillDescribe;
    private String name;
    private RpgSystem rpg;

    public WaterBall(RpgSystem rpg) {
        this.consumeMp = 50;
        this.name = "水球攻擊";
        this.rpg = rpg;
        this.skillDescribe = "消耗50點MP、一次攻擊所有怪物，魔法傷害值 50";
    }

    public int getConsumeMp() {
        return consumeMp;
    }

    @Override
    public int skillAttack(Hero hero, Monster attacked) {
        hero.setMp(hero.getMp() - consumeMp);
        int damage = 0;
        for (Monster monster : rpg.getMonsters()) {
            if (50 - monster.getMdf() >= 0) {
                damage += 50 - monster.getMdf();
                monster.setHp(monster.getHp() - 50 - monster.getMdf());
                return damage;
            }
            return damage;
        }
        return rpg.getMonsters().size() * 50;
    }

    @Override
    public String getName() {
        return name;
    }

    public String getSkillDescribe() {
        return skillDescribe;
    }
}
