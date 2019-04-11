package Game;

import Weapon.Attack.AttackWeapon;
import Weapon.Attack.Glove;
import Weapon.Defense.Armor;
import Weapon.Defense.DefenseWeapon;
import Weapon.MagicPower.MagicPower;
import Weapon.MagicPower.ThunderBall;

public class BoxerWeaponFactory implements WeaponFactory {
    @Override
    public AttackWeapon getAttackWeapon() {
        return new Glove();
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
