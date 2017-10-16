package Role;

public class Ninja extends Role {

	public Ninja(String name, RoleEquipmentFactory roleEquipmentFactory) {
		super(name, roleEquipmentFactory);
	}

	@Override
	public void setHpAndMp() {
		this.hp = 15000;
		this.mp = 1000;
	}

}
