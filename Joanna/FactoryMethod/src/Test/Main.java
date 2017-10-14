package Test;
import java.util.Scanner;

import Role.Monster;
import Role.Player;

public class Main {
	
	public static void main(String[] argv) {
		Scanner input = new Scanner(System.in);
		Player player = new Player();
		Monster monster = new Monster(10000);
		int round = 0;
		
		while (monster.getHealthPoint() > 0) {
			round++;
			System.out.println("��"+ round + "�^�X�A��ܺj(1)�����j (2)���u�j (3)�����j");
			int selection = input.nextInt();
			player.chooseGun(selection);
			int damage = player.getSumDamage();
			System.out.println("�Ǫ�HP���" + damage);
			monster.decreaseHealthPoint(damage);
			System.out.println();
		}
		
		
		System.out.println("�C������!!! ��" + round + "�^�X���ѩǪ��n�δ�");
		
	}
	
}
