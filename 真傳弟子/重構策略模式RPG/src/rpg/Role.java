package rpg;


import Skill.Skill;

import java.util.ArrayList;
import java.util.List;

public abstract class Role {
    private String name;
    private int hp;
    private int mp ;
    private int atk ;
    private int def ;
    private int mdf ;
    private RpgSystem rpg;
    private boolean action = true;
    private int actionCount = 0;
    private List<Skill> skills = new ArrayList<>();
    private NormalAttack normalAttack = new Attack();

    public Role() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getMp() {
        return mp;
    }

    public void setMp(int mp) {
        this.mp = mp;
    }

    public int getAtk() {
        return atk;
    }

    public void setAtk(int atk) {
        this.atk = atk;
    }

    public int getDef() {
        return def;
    }

    public void setDef(int def) {
        this.def = def;
    }

    public int getMdf() {
        return mdf;
    }

    public void setMdf(int mdf) {
        this.mdf = mdf;
    }

    public RpgSystem getRpg() {
        return rpg;
    }

    public void setRpg(RpgSystem rpg) {
        this.rpg = rpg;
    }

    public boolean isAction() {
        return action;
    }

    public void setAction(boolean action) {
        this.action = action;
    }

    public int getActionCount() {
        return actionCount;
    }

    public  List<Skill> getSkills() {
        return skills;
    }

    public void setSkills(List<Skill> skills) {
        this.skills = skills;
    }

    public void setActionCount(int actionCount) {
        this.actionCount = actionCount;

    }
    public NormalAttack getNormalAttack() {
        return normalAttack;
    }

    public void setNormalAttack(NormalAttack attack) {
        this.normalAttack = attack;
    }
}
