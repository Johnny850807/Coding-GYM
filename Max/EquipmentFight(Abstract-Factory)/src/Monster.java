import Weapon.Attack.AttackWeapon;
import Weapon.Defense.DefenseWeapon;

public class Monster extends Hero{
	public Monster(){
		super("¨Î¨Î¤jÅ]¤ý");
	}
	public void setHeroEquipment(){
		heroEquipmentFactory = new MonsterEquipment();
		attackWeapon = heroEquipmentFactory.getAttackWeapon();
		defenseWeapon = heroEquipmentFactory.getDefenseWeapon();
		magicPower = heroEquipmentFactory.getMagicPower();
	}
	public void setHeroHpandMp(){
		hp = 5000;
		mp = 1000;
	}
	public AttackWeapon getAttackWeapon(){
		return attackWeapon;
	}
	public DefenseWeapon getDefenseWeapon(){
		return defenseWeapon;
	}
}
