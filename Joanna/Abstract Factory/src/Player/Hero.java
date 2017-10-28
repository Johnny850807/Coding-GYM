package Player;

import java.util.Scanner;

import Weapon.Attackable;
import Weapon.Weapon;

public class Hero extends Player {

	@Override
	protected String nameSelf() {
		Scanner input = new Scanner(System.in);
		System.out.println("�п�J�W�r:");
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
		System.out.println("��ܨ��� : (1) �Ԫ� (2) ���� (3) �Z�h");
		return input.nextInt();
	}

	@Override
	public Attackable selectAction() {
		Scanner input = new Scanner(System.in);
		System.out.println("��ܰʧ@ : (1) " + weapons[1].getName() +" (2) " + weapons[2].getName());
		return weapons[input.nextInt()];
	}

}
