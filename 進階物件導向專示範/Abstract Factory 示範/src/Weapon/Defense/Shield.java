package Weapon.Defense;

public class Shield  implements DefenseWeapon {

	@Override
	public String getName() {
		return "�޵P";
	}

	@Override
	public int getDefense() {
		return 250;
	}
	
	@Override
	public int getMagicDefense() {
		return 800;
	}

}

