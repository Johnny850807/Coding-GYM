package Role;

public class Hulk extends Role {

	public Hulk(String name, RoleEquipmentFactory roleEquipmentFactory) {
		super(name, roleEquipmentFactory);
	}

	@Override
	public void setHpAndMp() {
		hp = 18567;
		mp = 462;
	}

}
