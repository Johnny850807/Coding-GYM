package Game;

import Weapon.Attack.AttackWeapon;
import Weapon.Defense.Armor;
import Weapon.Defense.DefenseWeapon;
import Weapon.MagicPower.MagicPower;
import Weapon.Attack.Sword;
import Weapon.MagicPower.ThunderBall;

public class WarriorWeaponFactory implements WeaponFactory {
    @Override
    public AttackWeapon getAttackWeapon() {
        return new Sword();
    }

    @Override
    public MagicPower getMagicPower() {
        return new ThunderBall();
    }

    @Override
    public DefenseWeapon getDefenseWeapon() {
        return new Armor();
    }
}
