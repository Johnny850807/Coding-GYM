package Monster;


import monsterSkill.MonsterSkill;
import rpg.RpgSystem;

public abstract class Monster {
    private String name;
    private int hp = 0;
    private int mp = 0;
    private int atk = 0;
    private int def = 0;
    private int mdf = 0;
    private MonsterSkill skill = null;
    private RpgSystem rpg;
    private boolean action = true;
    private int actionCount = 0;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MonsterSkill getSkill() {
        return skill;
    }

    public void setSkill(MonsterSkill skill) {
        this.skill = skill;
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

    public void setActionCount(int actionCount) {
        this.actionCount = actionCount;
    }

    public void setRpg(RpgSystem rpg) {
        this.rpg = rpg;
    }
}
