import java.util.*;

import Weapon.*;
import Weapon.Attack.*;
import Weapon.MagicPower.*;
public class Main {
	static Hero hero ;
	public static void main(String[] args){
		Scanner s = new Scanner(System.in);
		Monster monster;
		FightStart fightstart;
		while(true){
			monster = new Monster();
			System.out.println("��J�^���W�� :");
			ChoicesHeor(s.nextLine());
			fightstart = new FightStart(hero , monster);
			System.out.println("----------------���j�u-------------------------");
		}
	}
	public static void ChoicesHeor(String name){
		boolean checkInput=false;
		Scanner scanner = new Scanner(System.in);
		int which = 0;
		while(!checkInput){
			System.out.println("��ܭ^��¾�~ : (1) ���Ԥh (2) �Ϊk�v (3) ���g�� :");
			which = scanner.nextInt();
			switch(which){
				case 1:
					checkInput = true;
					hero = new Warrior(name);
					break;
				case 2:
					checkInput = true;
					hero = new Magician(name);
					break;
				case 3:
					checkInput = true;
					hero = new Gunman(name);
					break;
				default:
					System.out.println("�п�J���T�n��????");
			}
		}
	}
	
}
