package Role;

import Weapon.Bodysuit;
import Weapon.VoltTackle;
import Weapon.Attack.AttackWeapon;
import Weapon.Attack.Glove;
import Weapon.Defense.DefenseWeapon;
import Weapon.MagicPower.MagicPower;

public class FlashEquipmentFactory implements RoleEquipmentFactory{

	@Override
	public AttackWeapon setUpAttackWeapon() {
		return new Glove();
	}

	@Override
	public DefenseWeapon setUpDefenseWeapon() {
		return new Bodysuit();
	}

	@Override
	public MagicPower setUpMagicPower() {
		return new VoltTackle();
	}

}
