package Client.Role;

import java.util.Random;

import Client.Factory.SansWeaponsFactory;
import Client.Factory.UserPreferenceFactory;
import Client.Factory.WeaponsFactory;
import Weapon.Attackable;

public class Sans extends Role {

	@Override
	protected String initName() {
		return "Sans";
	}

	@Override
	protected int initHp() {
		return 18000;
	}
	
	@Override
	protected int initMp() {
		return 2000;
	}

	@Override
	protected WeaponsFactory initFactory() {
		return new SansWeaponsFactory();
	}

	@Override
	protected Attackable toMakeChoice() {
		int choice;
		if (!isMpEnoughToUseMagic())
			choice = 0;
		else
			choice = new Random().nextInt(2) + 1;
		return UserPreferenceFactory.getPreferredAttackFromRole(choice, this);
	}

}
