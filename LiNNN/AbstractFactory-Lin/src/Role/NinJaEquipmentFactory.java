package Role;

import Weapon.Attack.AttackWeapon;
import Weapon.Attack.Darts;
import Weapon.Defense.Armor;
import Weapon.Defense.DefenseWeapon;
import Weapon.MagicPower.MagicPower;
import Weapon.MagicPower.ThunderBall;

public class NinJaEquipmentFactory implements RoleEquipmentFactory{

	@Override
	public AttackWeapon setUpAttackWeapon() {
		return new Darts();
	}

	@Override
	public DefenseWeapon setUpDefenseWeapon() {
		return new Armor();
	}

	@Override
	public MagicPower setUpMagicPower() {
		return new ThunderBall();
	}

}
