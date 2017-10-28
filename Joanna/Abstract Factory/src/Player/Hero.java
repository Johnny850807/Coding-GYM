package Player;

import java.util.Scanner;

import Weapon.Attackable;
import Weapon.Weapon;

public class Hero extends Player {

	@Override
	protected String nameSelf() {
		Scanner input = new Scanner(System.in);
		System.out.println("請輸入名字:");
		return input.next();
	}

	@Override
	protected int initHealthPoint() {
		return 10000;
	}

	@Override
	protected int initMagicPoint() {
		return 5000;
	}

	@Override
	public int selectRole() {
		Scanner input = new Scanner(System.in);
		System.out.println("選擇角色 : (1) 忍者 (2) 拳皇 (3) 武士");
		return input.nextInt();
	}

	@Override
	public Attackable selectAction() {
		Scanner input = new Scanner(System.in);
		System.out.println("選擇動作 : (1) " + weapons[1].getName() +" (2) " + weapons[2].getName());
		return weapons[input.nextInt()];
	}

}
