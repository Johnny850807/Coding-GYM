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
				System.out.println("�� " + (++round) + " �^�X");
				System.out.println("�Ǫ�Hp : " + monster.getMonsterHp());
				hero.setHeroGun(ChoicesGun());
				damage = hero.getGunDamage();
				System.out.println("�^�� \"����\"�y�����ˮ` : " + damage);
				monster.beAttacked(damage);
				if(monster.getMonsterHp() <= 0){
					System.out.println("�Ǫ����F~");
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
			System.out.println("��J�Ʀr1~3��ܨϥ� --1:�����j--2:���u�j--3:�����j");
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
					System.out.println("�п�J���T");
			}
		}
		return which;
	}
}
