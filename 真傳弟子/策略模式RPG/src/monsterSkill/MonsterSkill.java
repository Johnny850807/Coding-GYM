package monsterSkill;


import Monster.Monster;
import rpg.Hero;

public interface MonsterSkill {

    int skillAttack(Monster attack, Hero attacked);

    String getName();

}
