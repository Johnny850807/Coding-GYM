
import java.util.*;

import Bullet.*;

public class Main {
	private static Scanner scanner = new Scanner(System.in);
	private static int count;
	private static Hero hero = new Hero();
	private static Monster monster;
	public static void main(String[] args) {
		initMonsterAndShow();
		fight();
		System.out.printf("使用回合數  %d%n" , count);
	}
	
	private static void initMonsterAndShow(){
		monster = new Monster(new Random().nextInt(3000)+1950);
		System.out.printf("== 遇到怪物 生命 %d%n" , monster.getHp());
	}
	
	private static void fight(){
		do
		{
			count ++;
			hero.shootMonsterWithSpecifiedNumOfGuns(monster, bulletChoosing());
			System.out.printf("怪物生命剩下 %d%n" , monster.getHp());
		}while(!monster.isDead());
	}
	
	private static int bulletChoosing(){
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
	
}
