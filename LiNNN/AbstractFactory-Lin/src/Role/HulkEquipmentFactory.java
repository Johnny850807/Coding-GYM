package Role;

import Weapon.MegaPunch;
import Weapon.Punch;
import Weapon.Attack.AttackWeapon;
import Weapon.Defense.Armor;
import Weapon.Defense.DefenseWeapon;
import Weapon.MagicPower.MagicPower;

public class HulkEquipmentFactory implements RoleEquipmentFactory{

	@Override
	public AttackWeapon setUpAttackWeapon() {
		return new Punch();
	}

	@Override
	public DefenseWeapon setUpDefenseWeapon() {
		return new Armor();
	}

	@Override
	public MagicPower setUpMagicPower() {
		return new MegaPunch();
	}

}
