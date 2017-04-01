package Weapon.Defense;

import Weapon.Weapon;

public interface DefenseWeapon extends Weapon{
	String getName();
	int getDefense();
	int getMagicDefense();
}
