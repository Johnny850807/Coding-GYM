import java.util.*;
public class Main {
	static Scanner scanner = new Scanner(System.in);
	public static void main(String[] args){
		int damage = 0;
		int round = 0;
		boolean gameOver;
		Monster monster;
		Hero hero;
		while(true){
			round = 0;
			gameOver = false;
			monster = new Monster();
			hero = new Hero();
			do{
				System.out.println("第 " + (++round) + " 回合");
				System.out.println("怪物Hp : " + monster.getMonsterHp());
				hero.setHeroGun(ChoicesGun());
				damage = hero.getGunDamage();
				System.out.println("英雄 \"忠忠\"造成的傷害 : " + damage);
				monster.beAttacked(damage);
				if(monster.getMonsterHp() <= 0){
					System.out.println("怪物死了~");
					gameOver = true;
				}
			}while(!gameOver);
			System.out.println();
		}
	}
	public static int ChoicesGun(){
		boolean checkInput=false;
		int which = 0;
		while(!checkInput){
			System.out.println("輸入數字1~3選擇使用 --1:機關槍--2:散彈槍--3:狙擊槍");
			which = scanner.nextInt();
			switch(which){
				case 1:
					checkInput = true;
					break;
				case 2:
					checkInput = true;
					break;
				case 3:
					checkInput = true;
					break;
				default:
					System.out.println("請輸入正確");
			}
		}
		return which;
	}
}
