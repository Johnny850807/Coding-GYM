package Player;

import Role.Boxer;
import Role.Ninja;
import Role.Role;
import Role.Swordsman;
import Weapon.Attackable;
import Weapon.Weapon;
import Weapon.Attack.AttackWeapon;
import Weapon.Defense.DefenseWeapon;

public abstract class Player {

	protected String name;
	protected int healthPoint;
	protected int magicPoint;
	protected Role role;
	protected Attackable[] weapons = new Attackable[3];
	protected DefenseWeapon defenseWeapon;
	
	public Player() {
		name = nameSelf();
		healthPoint = initHealthPoint();
		magicPoint = initHealthPoint();
	}
	
	protected abstract String nameSelf();
	protected abstract int initHealthPoint();
	protected abstract int initMagicPoint();
	public abstract int selectRole();
	public abstract Attackable selectAction();
	
	public String getName() {
		return name;
	}
	
	public int getHealthPoint() {
		return healthPoint;
	}

	public int getMagicPoint() {
		return magicPoint;
	}

	public DefenseWeapon getDefenseWeapon() {
		return defenseWeapon;
	}
	
	public void addHealthPoint(int healthPoint) {
		this.healthPoint += healthPoint;
	}
	
	public void addMagicPoint(int magicPoint) {
		this.magicPoint += magicPoint;
	}
	
	public void gotHurted(Attackable weapon) {
		int repeat = weapon.getReaptedTimes();
		int sumDamage = 0, defense;
		defense = (weapon instanceof AttackWeapon)? defenseWeapon.getDefense() : defenseWeapon.getMagicDefense();
		
		for (int i = 0; i < repeat; i++) {
			int damage = weapon.getInjury() - defense < 0 ? 0 : weapon.getInjury() - defense;
			sumDamage += damage;
			System.out.println(damage);
		}
		
		healthPoint -= sumDamage;
	}
	
	public void subtractMagicPoint(int magicPoint) {
		this.magicPoint -= magicPoint;
	}
	
	public void setRole(int roleSelection) {
		switch (roleSelection) {
			case 1:
				role = new Ninja();
				break;
			case 2:
				role = new Boxer();
				break;
			case 3:
				role = new Swordsman();
				break;
			default:
				break;
		}
		
		defenseWeapon = role.createDefenseWeapon();
		weapons[1] = role.createAttackWeapon();
		weapons[2] = role.createMagicPower();
	}
	
}
