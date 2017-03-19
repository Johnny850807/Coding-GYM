import java.util.Random;
import java.util.Scanner;

public class MonsterAction {
	Monster monster;
	private int random ;
	private int damage = 0;
	public MonsterAction(Monster monster){
		this.monster = monster;
		printStatus();
		ChoiceHeroAction();
	}
	public void printStatus(){
		System.out.println(monster.name + " ���A");
		System.out.println( "Hp : " + monster.hp + "\nMp : " + monster.mp);
	}
	public void ChoiceHeroAction(){
		boolean check = false;
		int repeatTimes;
		System.out.println("��ܰʧ@ : "+ "\n 1. " + monster.attackWeapon.getName() + " Mp���� : " + monster.attackWeapon.getLoseMp() 
		+ "\n 2. " + monster.magicPower.getName() + " Mp���� : " + monster.magicPower.getLoseMp());
		while(!check){
			random = new Random().nextInt(2);
			switch(random){
				case 1:
					if(monster.mp - monster.attackWeapon.getLoseMp() < 0);
						//�o�̦����K����A��
					else{
						repeatTimes = monster.attackWeapon.getReaptedTimes();
						monster.consumptionHeroMp(monster.attackWeapon.getLoseMp());
						for (int i = 0 ; i < repeatTimes; i++){
							System.out.println(monster.attackWeapon.getName() + "�ˮ`" + monster.attackWeapon.getInjury());
							damage += monster.attackWeapon.getInjury();
						}
						check = true;
					}
					break;
				case 2:
					if(monster.mp - monster.magicPower.getLoseMp() < 0);
						//�o�̦����K����A��
					else{
						repeatTimes = monster.magicPower.getReaptedTimes();
						monster.consumptionHeroMp(monster.magicPower.getLoseMp());
						for (int i = 0 ; i < repeatTimes; i++){
							System.out.println(monster.magicPower.getName() + "�ˮ`" + monster.magicPower.getInjury());
							damage += monster.magicPower.getInjury();
						}
						check = true;
					}	
					break;
				default:
			}
		}
	}
	public int getDamage(){
		return this.damage;
	}
}
