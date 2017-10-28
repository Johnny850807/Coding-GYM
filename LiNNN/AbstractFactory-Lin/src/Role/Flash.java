package Role;

public class Flash extends Role{

	public Flash(String name, RoleEquipmentFactory roleEquipmentFactory) {
		super(name, roleEquipmentFactory);
	}

	@Override
	public void setHpAndMp() {
		hp = 12062;
		mp = 2143;
	}

}
