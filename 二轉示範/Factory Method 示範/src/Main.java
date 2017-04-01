
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
		System.out.printf("== �J��Ǫ� �ͩR %d%n" , monster.getHp());
	}
	
	static int bulletChoosing(){
		int choice;
		do
		{
			System.out.println("��ܤl�u (0)�����j (1)�����j (2)���u�j ");
			choice = scanner.nextInt();
			if (choice < 0 || choice > 2)
				System.out.println("��J���~");
		}while(choice < 0 || choice > 2);
		return choice;
	}
	
	static void shootingMonster(int numOfGun){
		hero.shootMonsterWithSpecifiedNumOfGuns(monster, numOfGun);
	}
	
	static void printMonsterInfo(){
		System.out.printf("�Ǫ��ͩR�ѤU %d%n" , monster.getHp());
	}
	
	static boolean judgeEnding(){
		return monster.isDead();
	}
	
	static void printFinalCount(){
		System.out.printf("�ϥΦ^�X��  %d%n" , hero.getCountRound());
	}

}
