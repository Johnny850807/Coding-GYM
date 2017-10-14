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
			System.out.println("第"+ round + "回合，選擇槍(1)機關槍 (2)散彈槍 (3)狙擊槍");
			int selection = input.nextInt();
			player.chooseGun(selection);
			int damage = player.getSumDamage();
			System.out.println("怪物HP減少" + damage);
			monster.decreaseHealthPoint(damage);
			System.out.println();
		}
		
		
		System.out.println("遊戲結束!!! 花" + round + "回合打敗怪物好棒棒");
		
	}
	
}
