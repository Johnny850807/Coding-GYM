package ImplementsWeapon;
import Weapon.Attack.AttackWeapon;

public class MonsterAttackWeapon implements AttackWeapon{

	@Override
	public int getLoseMp() {
		return 0;
	}
	@Override
	public int getInjury() {
		return 123;
	}
	@Override
	public String getName() {
		return "�ΨΥĤO";
	}

	@Override
	public int getReaptedTimes() {
		return 7;
	}
	
}
