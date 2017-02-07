package Weapon.MagicPower;

import Weapon.Attackable;
import Weapon.Weapon;

public interface MagicPower extends Attackable{
	String getName();
	int getInjury();
	int getLoseMp();
}
