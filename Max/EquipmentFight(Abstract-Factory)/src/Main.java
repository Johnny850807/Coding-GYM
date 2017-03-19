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
			System.out.println("輸入英雄名稱 :");
			ChoicesHeor(s.nextLine());
			fightstart = new FightStart(hero , monster);
			System.out.println("----------------分隔線-------------------------");
		}
	}
	public static void ChoicesHeor(String name){
		boolean checkInput=false;
		Scanner scanner = new Scanner(System.in);
		int which = 0;
		while(!checkInput){
			System.out.println("選擇英雄職業 : (1) 忠戰士 (2) 佳法師 (3) 水射手 :");
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
					System.out.println("請輸入正確好嗎????");
			}
		}
	}
	
}
