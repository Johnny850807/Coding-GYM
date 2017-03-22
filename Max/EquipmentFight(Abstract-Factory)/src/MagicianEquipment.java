import Weapon.Weapon;
import Weapon.Attack.AttackWeapon;
import Weapon.Attack.Sword;
import Weapon.Defense.Armor;
import Weapon.Defense.DefenseWeapon;
import Weapon.MagicPower.FireBall;
import Weapon.MagicPower.MagicPower;
import Weapon.MagicPower.ThunderBall;
public class MagicianEquipment implements HeroEquipmentFactory{
	public AttackWeapon getAttackWeapon(){
		return new Sword();
	}
	public DefenseWeapon getDefenseWeapon(){
		return new Armor();
	}
	public MagicPower getMagicPower(){
		return new ThunderBall();
	}
}
