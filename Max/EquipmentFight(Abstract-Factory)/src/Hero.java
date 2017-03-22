
import Weapon.Attack.AttackWeapon;
import Weapon.Defense.DefenseWeapon;
import Weapon.MagicPower.MagicPower;

public abstract class Hero {
	protected String name;
	protected HeroEquipmentFactory heroEquipmentFactory;
	protected AttackWeapon attackWeapon;
	protected DefenseWeapon defenseWeapon;
	protected MagicPower magicPower;
	protected int hp , mp;
	public Hero(String name){
		this.name = name;
		setHeroEquipment();
		setHeroHpandMp();
	}
	public String getName(){
		return name;
	}
	public void consumptionHeroHp(int damage){
		hp -= damage;
	}
	public void consumptionHeroMp(int consumption){
		mp -= consumption;
	}
	public abstract void setHeroEquipment();
	public abstract void setHeroHpandMp();
}
