import Weapon.*;
import Weapon.Attack.AttackWeapon;
import Weapon.Defense.DefenseWeapon;
import Weapon.MagicPower.MagicPower;
public interface HeroEquipmentFactory {
	public AttackWeapon getAttackWeapon();
	public DefenseWeapon getDefenseWeapon();
	public MagicPower getMagicPower();
}
