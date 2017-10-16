package Role;

import Weapon.Attackable;
import Weapon.Attack.AttackWeapon;
import Weapon.Defense.DefenseWeapon;
import Weapon.MagicPower.MagicPower;

public abstract class Role {

	protected String name;
	protected RoleEquipmentFactory roleEquipmentFactory;
	protected AttackWeapon attackWeapon;
	protected DefenseWeapon defenseWeapon;
	protected MagicPower magicPower;
	protected int hp;
	protected int mp;

	public Role(String name, RoleEquipmentFactory roleEquipmentFactory) {
		this.name = name;
		setUpRoleInfo(roleEquipmentFactory);
	}

	public void setUpRoleInfo(RoleEquipmentFactory roleEquipmentFactory) {
		attackWeapon = roleEquipmentFactory.setUpAttackWeapon();
		defenseWeapon = roleEquipmentFactory.setUpDefenseWeapon();
		magicPower = roleEquipmentFactory.setUpMagicPower();
		setHpAndMp();
	}

	public AttackWeapon getAttackWeapon() {
		return attackWeapon;
	}

	public DefenseWeapon getDefenseWeapon() {
		return defenseWeapon;
	}

	public MagicPower getMagicPower() {
		return magicPower;
	}

	public int getHp() {
		return hp <= 0 ? 0 : hp;
	}

	public int getMp() {
		return mp <= 0 ? 0 : mp;
	}

	public String getName() {
		return name;
	}

	public void getDamage(int damage) {
		this.hp -= damage;
	}

	public void consumptionMP(Attackable attackable) {
		this.mp -= attackable.getLoseMp();
	}

	public boolean isDead() {
		return hp <= 0 ? true : false;
	}

	public abstract void setHpAndMp();

}
