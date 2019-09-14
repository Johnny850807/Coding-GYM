package Game;

import Weapon.Attack.AttackWeapon;
import Weapon.Defense.DefenseWeapon;
import Weapon.Attack.Darts;
import Weapon.MagicPower.FireBall;
import Weapon.MagicPower.MagicPower;
import Weapon.Defense.Shield;

public class NinjaWeaponFactory implements WeaponFactory {
    @Override
    public AttackWeapon getAttackWeapon() {
        return new Darts();
    }

    @Override
    public MagicPower getMagicPower() {
        return new FireBall();
    }

    @Override
    public DefenseWeapon getDefenseWeapon() {
        return new Shield();
    }
}
