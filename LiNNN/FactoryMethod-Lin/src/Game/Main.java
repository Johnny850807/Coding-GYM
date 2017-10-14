package Game;

import java.util.Scanner;

public class Main {

	public static void main (String[] args) {
		Hero hero = new Hero();
		Monster monster = new Monster();
		Scanner input = new Scanner(System.in);
		int count = 0;
		
		do {
			count++;
			System.out.println("Please use 1. ExplosionGun 2. MachineGun 3. SniperGun");
			int choice = input.nextInt();
			monster.getDamage(hero.attack(choice));
			System.out.println("Monster's HP: " + monster.getHp());
		}while(!monster.isDead());
		System.out.println(count + "¦^¦Xµ²§ô!");
		
	}
	
}
