package Weapon.Attack;

import Weapon.Attackable;
import Weapon.Weapon;

public interface AttackWeapon extends Attackable{
	String getName();
	int getInjury();
	int getReaptedTimes();
}
