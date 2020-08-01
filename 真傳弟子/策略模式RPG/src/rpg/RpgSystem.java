package rpg;

import Monster.Monster;
import rpg.Hero;

import java.util.ArrayList;
import java.util.List;

public class RpgSystem {
    private Hero hero;
    private List<Monster> monsters = new ArrayList<>();
    private List<Monster> deadMonsters = new ArrayList<>();

    public RpgSystem() {
        hero = new Hero(this);
    }

    public int heroNormalAttack(Hero hero, Monster attacked) {
        int damage = 0;

        damage = hero.getAtk() - attacked.getDef();
        if (damage > 0) {
            attacked.setHp(attacked.getHp() - damage);
            return damage;
        }

        return 0;
    }

    public int monsterNormalAttack(Monster attack, Hero attacked) {
        int damage = 0;

        damage = attack.getAtk() - attacked.getDef();
        if (damage > 0) {
            attacked.setHp(attacked.getHp() - damage);
            return damage;
        }
        return 0;

    }

    public int heroSkillAttack(int selectSkill, Hero hero, Monster attacked) {
        int damage;

        damage = hero.getSkills()[selectSkill].skillAttack(hero, attacked);

        return damage;
    }

    public int monsterSkillAttack(Monster attack, Hero attacked) {
        int damage;

        damage = attack.getSkill().skillAttack(attack, attacked);

        return damage;

    }

    public Hero getHero() {
        return hero;
    }

    public void setHero(Hero hero) {
        this.hero = hero;
    }

    public List<Monster> getMonsters() {
        return monsters;
    }

    public void setMonsters(List<Monster> monsters) {
        this.monsters = monsters;
    }

    public void resetHeroState() {
        hero.setHp(500);
        hero.setMp(500);
        hero.setAtk(70);
        hero.setDef(40);
        hero.setMdf(10);
    }

    public boolean checkHeroUseSkillMp(int skillMp, Hero hero) {
        return skillMp < hero.getMp();
    }

    public boolean checkHeroAlive() {
        return hero.getHp() > 0;
    }

    public List<Monster> checkMonsterAlive() {
        for (int i = 0; i < monsters.size(); i++) {
            if (monsters.get(i).getHp() <= 0) {
                deadMonsters.add(monsters.get(i));
                monsters.remove(i);
            }
        }
        return deadMonsters;
    }
}
