package Sprite;

import Game.WeaponFactory;
import Weapon.Attack.AttackWeapon;
import Weapon.Defense.DefenseWeapon;
import Weapon.MagicPower.MagicPower;

public class Role {

    private AttackWeapon attackWeapon;
    private DefenseWeapon defenseWeapon;
    private MagicPower magicPower;
    private int HP;
    private int MP;
    private String name = "nil";

    public Role(int HP, int MP, WeaponFactory weaponFactory) {
        this.HP = HP;
        this.MP = MP;
        attackWeapon = weaponFactory.getAttackWeapon();
        defenseWeapon = weaponFactory.getDefenseWeapon();
        magicPower = weaponFactory.getMagicPower();
    }

    public AttackWeapon getAttackWeapon() {
        return attackWeapon;
    }

    public DefenseWeapon getDefenseWeapon() {
        return defenseWeapon;
    }

    public MagicPower getMagicPower() {
        return magicPower;
    }

    public void physicalAttack(Role opponent) {
        System.out.format("%s is trying to attack %s%n", name, opponent.name);
        opponent.sufferPhysicalAttackBy(this);
    }

    public void magicalAttack(Role opponent) {
        System.out.format("%s is trying to attack %s%n", name, opponent.name);
        if (magicPower.getLoseMp() > MP) {
            System.out.format("%s doesn't have enough MP...%n", name);
            return;
        }
        MP -= magicPower.getLoseMp();
        opponent.sufferMagicalAttackBy(this);
    }

    private void sufferPhysicalAttackBy(Role opponent) {
        int repeatedTimes = opponent.attackWeapon.getReaptedTimes();
        System.out.format("%d combos:%n", repeatedTimes);
        for (int i = 1; i <= repeatedTimes; i++) {
            int damage = opponent.attackWeapon.getInjury() - (int)(defenseWeapon.getDefense()*0.5);
            onDamage(damage, opponent, opponent.attackWeapon.getName());
        }
        System.out.println();
    }

    private void sufferMagicalAttackBy(Role opponent) {
        int damage = opponent.magicPower.getInjury() - (int)(defenseWeapon.getMagicDefense()*0.9);
        onDamage(damage, opponent, opponent.magicPower.getName());
    }

    private void onDamage(int damage, Role opponent, String weaponName) {
        if (damage > 0) {
            HP = damage > HP ? 0 : HP - damage;
            System.out.format("%s just suffered %s damage by %s from %s%n",
                    name, damage, weaponName, opponent.name);
        } else {
            System.out.format("%s just suffered %s damage by %s from %s...%n",
                    name, "no", weaponName, opponent.name);
        }
    }

    public boolean isDead() {
        return HP <= 0;
    }

    public void showStatus() {
        System.out.println(name + " : HP = " + HP + ", MP = " + MP);
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
