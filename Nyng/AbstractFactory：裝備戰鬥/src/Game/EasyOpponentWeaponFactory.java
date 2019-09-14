package Game;

import Weapon.Attack.AttackWeapon;
import Weapon.Attack.Gun;
import Weapon.Defense.Armor;
import Weapon.Defense.DefenseWeapon;
import Weapon.Defense.Skeleton;
import Weapon.MagicPower.MagicPower;
import Weapon.MagicPower.ThunderBall;


public class EasyOpponentWeaponFactory implements WeaponFactory {
    @Override
    public AttackWeapon getAttackWeapon() {
        return new Gun();
    }

    @Override
    public MagicPower getMagicPower() {
        return new ThunderBall();
    }

    @Override
    public DefenseWeapon getDefenseWeapon() {
        return new Skeleton();
    }
}
