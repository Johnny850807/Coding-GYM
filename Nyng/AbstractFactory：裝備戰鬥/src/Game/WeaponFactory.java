package Game;
import Weapon.Attack.AttackWeapon;
import Weapon.Defense.DefenseWeapon;
import Weapon.MagicPower.MagicPower;

public interface WeaponFactory {
    AttackWeapon getAttackWeapon();
    MagicPower getMagicPower();
    DefenseWeapon getDefenseWeapon();
}
