import ImplementsWeapon.MonsterAttackWeapon;
import ImplementsWeapon.MonsterDefenseWeapon;
import ImplementsWeapon.MonsterMagicPower;
import Weapon.Attack.AttackWeapon;
import Weapon.Defense.DefenseWeapon;
import Weapon.MagicPower.MagicPower;

public class MonsterEquipment implements HeroEquipmentFactory{
	@Override
	public AttackWeapon getAttackWeapon() {
		return new MonsterAttackWeapon();
	}

	@Override
	public DefenseWeapon getDefenseWeapon() {
		return new MonsterDefenseWeapon();
	}

	@Override
	public MagicPower getMagicPower() {
		return new MonsterMagicPower();
	}

}
