package ImplementsWeapon;
import Weapon.Defense.DefenseWeapon;

public class MonsterDefenseWeapon implements DefenseWeapon {

	@Override
	public int getDefense() {
		return 500;
	}

	@Override
	public int getMagicDefense() {
		return 500;
	}

	@Override
	public String getName() {
		return "µw";
	}

}
