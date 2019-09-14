package Game;

import Weapon.Attack.AttackWeapon;
import Weapon.Attack.Darts;
import Weapon.Attack.Gun;
import Weapon.Defense.Armor;
import Weapon.Defense.DefenseWeapon;
import Weapon.Defense.Skeleton;
import Weapon.MagicPower.FireBall;
import Weapon.MagicPower.MagicPower;

public class HardOpponentWeaponFactory implements WeaponFactory {
    @Override
    public AttackWeapon getAttackWeapon() {
        return new Gun();
    }

    @Override
    public MagicPower getMagicPower() {
        return new FireBall();
    }

    @Override
    public DefenseWeapon getDefenseWeapon() {
        return new Skeleton();
    }
}
