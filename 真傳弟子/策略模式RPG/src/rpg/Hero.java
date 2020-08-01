package rpg;

import HeroSkill.HeroSkill;

public class Hero {
    private int hp = 500;
    private int mp = 500;
    private int atk = 70;
    private int def = 40;
    private int mdf = 10;
    private HeroSkill[] skills;
    private RpgSystem rpg;

    public Hero(RpgSystem rpg) {
        this.rpg = rpg;
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

    public HeroSkill[] getSkills() {
        return skills;
    }

    public void setSkills(HeroSkill[] skills) {
        this.skills = skills;
    }

    public void addSkill(HeroSkill skill) {
        int originalSkillLength = skills.length;

        HeroSkill[] newSkill = new HeroSkill[originalSkillLength + 1];
        for (int i = 0; i < originalSkillLength; i++) {
            newSkill[i] = skills[i];
        }
        newSkill[originalSkillLength] = skill;
        skills = newSkill;
    }

    @Override
    public String toString() {
        return "玩家目前狀態為[" + "生命值=" + hp + ", 魔力值=" + mp + ", 攻擊力=" + atk + ", 防禦力=" + def + ", 魔法防禦力=" + mdf + ']';
    }
}
