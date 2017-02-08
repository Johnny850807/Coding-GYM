package Client.Role;

import java.util.Scanner;

import Client.Factory.*;
import Weapon.Attackable;

public class Hero extends Role{
	
	@Override
	protected int initHp() {
		return 20000;
	}
	
	@Override
	protected int initMp() {
		return 1000;
	}
	
	@Override
	protected String initName() {
		return inputPreferredName();
	}
	
	private String inputPreferredName(){
		String name;
		do
		{
			System.out.println("�п�J�W�l:");
			name = scanner.nextLine();
		}while( name.length() == 0 );
		return name;
	}
	
	@Override
	protected WeaponsFactory initFactory() {
		int choice = inputPreferredWeaponSetNumber();
		return UserPreferenceFactory.getPreferredWeapon(choice);
	}
	
	private int inputPreferredWeaponSetNumber(){
		int num;
		do
		{
			System.out.println("��ܨ��� : (1) �Ԫ� (2) �Z�h (3) ���� :");
			num = scanner.nextInt();
			if ( num < 1 || num > 3 )
				System.out.println("��J���~");
		}while( num < 1 || num > 3);
		return num;
	}
	
	@Override
	public Attackable toMakeChoice() {
		int choice = inputChoice();
		return UserPreferenceFactory.getPreferredAttackFromRole(choice, this);
	}
	
	private int inputChoice(){
		int choice;
		do
		{
			System.out.printf("��ܰʧ@ : (1) %s (2) %s %n" , 
					attackWeapon.getName() , magicPower.getName() );
			choice = scanner.nextInt();
			if ( choice < 1 || choice > 2 )
				System.out.println("��J���~");
			else if (!isMpEnoughToUseMagic())
				System.out.println("�]�O����");
		}while( choice < 1 || choice > 2 || !isMpEnoughToUseMagic());
		return choice;
	}

	
}
