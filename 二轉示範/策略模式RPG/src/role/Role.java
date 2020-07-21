package role;

import battle.Battle;
import role.decision.Decision;
import role.status.Normal;
import role.status.Status;
import skills.Skill;

import java.util.List;

/**
 * @author johnny850807@gmail.com (Waterball))
 */
public abstract class Role implements Decision {
    private Battle battle;
    private String name;
    private Status status = new Normal(this);
    private Capability capability;
    private Capability fixedCapability;
    private Skill[] skills;

    public Role(String name, Capability capability, Skill... skills) {
        this.name = name;
        this.capability = capability;
        this.skills = skills;
        this.fixedCapability = capability.clone();
    }

    public Battle getBattle() {
        return battle;
    }

    public void setBattle(Battle battle) {
        this.battle = battle;
    }

    public int doDamage(int damage) {
        return status.doDamage(damage);
    }

    public int doMagicDamage(int magicDamage) {
        return status.doMagicDamage(magicDamage);
    }

    public void useSkill(int skillIndex) {
        status.useSkill(skillIndex);
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void move() {
        status.move();
    }

    public List<Skill> getAvailableSkills() {
        return status.getAvailableSkills();
    }

    public Skill getSkill(int skillNumber) {
        return getSkills()[skillNumber];
    }

    public Skill[] getSkills() {
        return skills;
    }

    public void restore() {
        this.capability = fixedCapability.clone();
    }

    public Capability getCapability() {
        return capability;
    }

    public String getName() {
        return name;
    }

    public void lostHp(int lost) {
        setHp(getHp() - lost);
    }

    public boolean isDead() {
        return getHp() <= 0;
    }

    public int getHp() {
        return capability.hp;
    }

    public void setHp(int hp) {
        this.capability.hp = hp;
    }

    public int getMp() {
        return capability.mp;
    }

    public void consumeMp(int consumedMp) {
        if (consumedMp > getMp()) {
            throw new MagicNotEnoughException();
        }
        setMp(getMp() - consumedMp);
    }

    public void setMp(int mp) {
        this.capability.mp = mp;
    }

    public int getAttackPoint() {
        return capability.attackPoint;
    }

    public void setAttackPoint(int attackPoint) {
        this.capability.attackPoint = attackPoint;
    }

    public int getDefence() {
        return capability.defence;
    }

    public void setDefence(int defence) {
        this.capability.defence = defence;
    }

    public int getMagicDefence() {
        return capability.magicDefence;
    }

    public void setMagicDefence(int magicDefence) {
        this.capability.magicDefence = magicDefence;
    }

    @Override
    public String toString() {
        return String.format("%s (%s)", getName(), capability);
    }
}
