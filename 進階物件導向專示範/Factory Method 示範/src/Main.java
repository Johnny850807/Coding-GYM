
import java.util.*;

import Bullet.*;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	static Hero hero = new Hero();
	static Monster monster;
	public static void main(String[] args) {
		initMonsterAndShow();
		do
		{
			shootingMonster(bulletChoosing());
			printMonsterInfo();
		}while(!judgeEnding());
	}
	
	static void initMonsterAndShow(){
		monster = new Monster(new Random().nextInt(3000)+1950);
		representMonster();
	}
	
	static void representMonster(){
		System.out.printf("== 遇到怪物 生命 %d%n" , monster.getHp());
	}
	
	static int bulletChoosing(){
		int choice;
		do
		{
			System.out.println("選擇子彈 (0)機關槍 (1)狙擊槍 (2)散彈槍 ");
			choice = scanner.nextInt();
			if (choice < 0 || choice > 2)
				System.out.println("輸入錯誤");
		}while(choice < 0 || choice > 2);
		return choice;
	}
	
	static void shootingMonster(int numOfGun){
		hero.shootMonsterWithSpecifiedNumOfGuns(monster, numOfGun);
	}
	
	static void printMonsterInfo(){
		System.out.printf("怪物生命剩下 %d%n" , monster.getHp());
	}
	
	static boolean judgeEnding(){
		return monster.isDead();
	}
	
	static void printFinalCount(){
		System.out.printf("使用回合數  %d%n" , hero.getCountRound());
	}

}
