
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
		System.out.printf("�ϥΦ^�X��  %d%n" , count);
	}
	
	private static void initMonsterAndShow(){
		monster = new Monster(new Random().nextInt(3000)+1950);
		System.out.printf("== �J��Ǫ� �ͩR %d%n" , monster.getHp());
	}
	
	private static void fight(){
		do
		{
			count ++;
			hero.shootMonsterWithSpecifiedNumOfGuns(monster, bulletChoosing());
			System.out.printf("�Ǫ��ͩR�ѤU %d%n" , monster.getHp());
		}while(!monster.isDead());
	}
	
	private static int bulletChoosing(){
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
	
}
