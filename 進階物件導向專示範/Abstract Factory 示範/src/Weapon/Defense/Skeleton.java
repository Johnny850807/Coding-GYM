package Weapon.Defense;

public class Skeleton  implements DefenseWeapon{

	@Override
	public String getName() {
		return "����";
	}

	@Override
	public int getDefense() {
		return 150;
	}
	
	@Override
	public int getMagicDefense() {
		return 300;
	}

}

