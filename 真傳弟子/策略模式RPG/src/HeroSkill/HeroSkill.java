package HeroSkill;


import Monster.Monster;
import rpg.Hero;

public interface HeroSkill {
    int skillAttack(Hero hero, Monster attacked);

    String getName();

    String getSkillDescribe();

    int getConsumeMp();
}
