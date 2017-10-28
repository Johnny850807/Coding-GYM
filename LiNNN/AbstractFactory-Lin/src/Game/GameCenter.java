package Game;

import java.util.Scanner;

import Role.Flash;
import Role.FlashEquipmentFactory;
import Role.Hulk;
import Role.HulkEquipmentFactory;
import Role.NinJaEquipmentFactory;
import Role.Ninja;
import Role.Role;

public class GameCenter {
	private Role user;
	private Role enemy;
	private boolean gameover = false;
	Scanner input = new Scanner(System.in);

	public void createRole() {
		System.out.print("請輸入名字: ");
		String name = input.nextLine();
		System.out.println("請選擇角色: (1) 忍者 (2) 閃電俠 (3) 浩克");
		int choice = input.nextInt();
		switch (choice) {
		case 1:
			user = new Ninja(name, new NinJaEquipmentFactory());
			break;
		case 2:
			user = new Flash(name, new FlashEquipmentFactory());
			break;
		case 3:
			user = new Hulk(name, new HulkEquipmentFactory());
			break;
		}
	}

	public void createEnemy() {
		String name = "電腦Bot";
		int choice = (int) (Math.random() * 3 + 1);
		switch (choice) {
		case 1:
			enemy = new Ninja(name, new NinJaEquipmentFactory());
			break;
		case 2:
			enemy = new Flash(name, new FlashEquipmentFactory());
			break;
		case 3:
			enemy = new Hulk(name, new HulkEquipmentFactory());
			break;
		}
	}

	public void selectRole(Role role, int choice) {

	}

	public void gameStart() {
		Role winner;
		do {
			turnToUser();
			System.out.println("===============");
			turnToEnemy();
			if (user.isDead() || enemy.isDead())
				gameover = true;
		} while (!gameover);
		winner = user.isDead() ? enemy : user;
		System.out.println(winner.getName() + "勝利!!");
	}

	public void turnToUser() {
		System.out.println("輪到: " + user.getName());
		showStatus(user);
		System.out.println("選擇攻擊方式: (1)" + user.getAttackWeapon().getName() + " (2) " + user.getMagicPower().getName());
		int choice = input.nextInt();
		enemy.getDamage(attackMode(choice, user));
	}

	public void turnToEnemy() {
		System.out.println("輪到: " + enemy.getName());
		showStatus(enemy);
		int enemyChoice = (int) (Math.random() * 2 + 1);
		user.getDamage(attackMode(enemyChoice, enemy));
	}

	public void showStatus(Role role) {
		System.out.println("狀態: HP " + role.getHp() + " MP " + role.getMp());
	}

	public int attackMode(int choice, Role role) {
		int damage = 0, attack = 0;
		if (choice == 1) {
			if ((role.getMp() - role.getAttackWeapon().getLoseMp()) < 0)
				System.out.println("MP不足，攻擊失敗!!");
			else {
				System.out.println(role.getName() + " 使用 " + role.getAttackWeapon().getName());
				role.consumptionMP(role.getMagicPower());
				for (int i = 0; i < role.getAttackWeapon().getReaptedTimes(); i++) {
					attack = role.getAttackWeapon().getInjury();
					System.out.println("===" + attack + "===");
					damage += attack;
				}
			}
		} else {
			if ((role.getMp() - role.getAttackWeapon().getLoseMp()) < 0)
				System.out.println("MP不足，攻擊失敗!!");
			else {
				System.out.println(role.getName() + " 使用 " + role.getMagicPower().getName());
				role.consumptionMP(role.getMagicPower());
				for (int i = 0; i < role.getMagicPower().getReaptedTimes(); i++) {
					attack = role.getMagicPower().getInjury();
					System.out.println("===" + attack + "===");
					damage += attack;
				}
			}
		}
		return damage;
	}

}
