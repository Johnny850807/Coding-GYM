package role.model;

import java.util.stream.Collectors;

abstract public class Role {
    public static int keyNumber = 1;
    protected String name;
    protected int roleNumber;
    protected int hp;
    protected int mp;
    protected int ap;
    protected int df;
    protected int mdf;
    protected ExtraStatus extraStatus = new ExtraStatus();
    protected boolean turnMe = false;

    public ExtraStatus getExtraStatus() {
        return extraStatus;
    }

    public Role(String name, int hp, int mp, int ap, int df, int mdf) {
        this.name = name;
        this.roleNumber = keyNumber++;
        this.hp = hp;
        this.mp = mp;
        this.ap = ap;
        this.df = df;
        this.mdf = mdf;
    }

    public boolean isTurnMe() {
        return turnMe;
    }

    public void setTurnMe(boolean turnMe) {
        this.turnMe = turnMe;
    }

    public void checkEffects() {
        this.getExtraStatus().getSkillExtraDamages().addAll(
                this.getExtraStatus().getSkillExtraDamages().stream().filter(SkillExtraDamage::isAble).collect(Collectors.toList()));
    }

    public void plusDfValue(int df) {
        this.df += df;
    }

    public void useMp(int mp) {
        this.mp -= mp;
    }

    public void useHp(int hp) {
        this.hp -= hp;
    }

    public void showStatus() {
        System.out.println(" status= " + this.toString());
    }

    public void minsMdf(int mattack) {
        if (this.mdf != 0) {
            this.mdf -= mattack;
        }
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return " 狀態{ 角色= " + this.name +
                " hp= " + hp +
                ", mp= " + mp +
                ", ap= " + ap +
                ", df= " + df +
                ", mdf= " + mdf +
                '}';
    }

    public int getHp() {
        return hp;
    }

    public boolean isExist() {
        return this.hp > 0;
    }

    public int getMp() {
        return mp;
    }

    public int getAp() {
        return ap;
    }

    public int getDf() {
        return df;
    }

    public int getMdf() {
        return mdf;
    }

    public boolean isMpUseAble(int useMp) {
        int usemp = getMp() - useMp;
        if (usemp < 0) {
            System.out.println("MP不足 " + usemp);
            return false;
        } else {
            return true;
        }
    }

    public abstract void action(Round round);
}
