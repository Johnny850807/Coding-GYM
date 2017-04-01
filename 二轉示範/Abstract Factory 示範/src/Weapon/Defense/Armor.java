package Weapon.Defense;

public class Armor implements DefenseWeapon{

	@Override
	public String getName() {
		return "²¯¥Ò";
	}

	@Override
	public int getDefense() {
		return 600;
	}

	@Override
	public int getMagicDefense() {
		return 300;
	}
	

}
