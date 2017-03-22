import Weapon.Attack.AttackWeapon;
import Weapon.Defense.DefenseWeapon;
import Weapon.MagicPower.MagicPower;
public class Gunman extends Hero{
	public Gunman(String name){
		super(name);
	}
	public void setHeroEquipment(){
		heroEquipmentFactory = new GunmanEquipment();
		attackWeapon = heroEquipmentFactory.getAttackWeapon();
		defenseWeapon = heroEquipmentFactory.getDefenseWeapon();
		magicPower = heroEquipmentFactory.getMagicPower();
	}
	public void setHeroHpandMp(){
		hp = 1000;
		mp = 500;
	}
	public AttackWeapon getAttackWeapon(){
		return attackWeapon;
	}
	public DefenseWeapon getDefenseWeapon(){
		return defenseWeapon;
	}
	public MagicPower getMagicPower(){
		return magicPower;
	}
}
