import Weapon.Weapon;
import Weapon.Attack.*;
import Weapon.Defense.*;
import Weapon.MagicPower.*;
public class GunmanEquipment implements HeroEquipmentFactory{
	public AttackWeapon getAttackWeapon(){
		return new Gun();
	}
	public DefenseWeapon getDefenseWeapon(){
		return new Armor();
	}
	public MagicPower getMagicPower(){
		return new FireBall();
	}
}
