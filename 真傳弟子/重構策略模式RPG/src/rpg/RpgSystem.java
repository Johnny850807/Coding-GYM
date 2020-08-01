package rpg;


import Skill.FireBall;
import Skill.Freeze;
import Skill.StrengthenBody;
import Skill.WaterBall;

import java.util.ArrayList;
import java.util.List;

public class RpgSystem {
    private Role hero = new Hero();
    private Monster monster = new MonsterFactory(this);
    private List<Role> monsters = new ArrayList<>();
    private List<Role> deadMonsters = new ArrayList<>();

    public RpgSystem() {
    }

    public void setInitialHeroSkill() {
        hero.getSkills().add(new FireBall());
        hero.getSkills().add(new Freeze());
        hero.getSkills().add(new StrengthenBody());
        hero.getSkills().add(new WaterBall(this));
    }

    public int normalAttack(Role attack, Role attacked) {
        return attack.getNormalAttack().attack(attack, attacked);
    }

    public int skillAttack(int selectSkill, Role attack, Role attacked) {
        return attack.getSkills().get(selectSkill).skillAttack(attack, attacked);
    }

    public void createMonster() {
        monster.setupAllMonsters();
    }

    public void resetHeroState() {
        hero.setHp(500);
        hero.setMp(500);
        hero.setAtk(70);
        hero.setDef(40);
        hero.setMdf(10);
    }

    public boolean checkHeroUseSkillMp(int skillMp, Role hero) {
        if (skillMp > hero.getMp()) {
            System.out.println("魔力不足請重新選擇");
        }
        return skillMp < hero.getMp();
    }

    public boolean checkHeroAlive() {
        return hero.getHp() > 0;
    }

    public void checkMonsterAlive() {
        for (int i = monsters.size() - 1; i >= 0; i--) {
            if (monsters.get(i).getHp() <= 0) {
                deadMonsters.add(monsters.get(i));
                monsters.remove(i);
            }
        }
    }

    public void aiAttackMethod() {
        new MonsterAttack(this).aiAttack();
    }

    public Role getHero() {
        return hero;
    }

    public void setHero(Role hero) {
        this.hero = hero;
    }

    public void setMonsters(List<Role> monsters) {
        this.monsters = monsters;
    }

    public List<Role> getDeadMonsters() {
        return deadMonsters;
    }

    public void setDeadMonsters(List<Role> deadMonsters) {
        this.deadMonsters = deadMonsters;
    }

    public List<Role> getMonsters() {
        return monsters;
    }
}
