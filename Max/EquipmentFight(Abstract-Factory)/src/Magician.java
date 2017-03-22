
import Weapon.Attack.AttackWeapon;
import Weapon.Defense.DefenseWeapon;

public class Magician extends Hero{
	public Magician(String name){
		super(name);
	}
	public void setHeroEquipment(){
		heroEquipmentFactory = new WarriorEquipment();
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
}
