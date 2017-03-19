import java.util.Scanner;

import Weapon.Attackable;
import Weapon.Weapon;
import Weapon.Attack.AttackWeapon;
public class HeroChoiceAction{
	private Hero hero;
	private Scanner scanner = new Scanner(System.in);
	private int damage = 0;
	public HeroChoiceAction(Hero hero){
		this.hero = hero;
		printStatus();
		ChoiceHeroAction();
	}
	public void printStatus(){
		System.out.println(hero.name + " ���A");
		System.out.println( "Hp : " + hero.hp + "\nMp : " + hero.mp);
	}
	public void ChoiceHeroAction(){
		boolean check = false;
		int which , repeatTimes;
		
		System.out.println("��ܰʧ@ : "+ "\n 1. " + hero.attackWeapon.getName() + " Mp���� : " + hero.attackWeapon.getLoseMp() 
		+ "\n 2. " + hero.magicPower.getName() + " Mp���� : " + hero.magicPower.getLoseMp());
		while(!check){
			which = scanner.nextInt();
			switch(which){
				case 1:
					if(hero.mp - hero.attackWeapon.getLoseMp() < 0)
						System.out.println("�]�O�����Э��s���");
					else{
						repeatTimes = hero.attackWeapon.getReaptedTimes();
						hero.consumptionHeroMp(hero.attackWeapon.getLoseMp());
						for (int i = 0 ; i < repeatTimes; i++){
							System.out.println(hero.attackWeapon.getName() + "�ˮ`" + hero.attackWeapon.getInjury());
							damage += hero.attackWeapon.getInjury();
						}
						check = true;
					}
					break;
				case 2:
					if(hero.mp - hero.magicPower.getLoseMp() < 0)
						System.out.println("�]�O�����Э��s���");
					else{
						repeatTimes = hero.magicPower.getReaptedTimes();
						hero.consumptionHeroMp(hero.magicPower.getLoseMp());
						for (int i = 0 ; i < repeatTimes; i++){
							System.out.println(hero.magicPower.getName() + "�ˮ`" + hero.magicPower.getInjury());
							damage += hero.magicPower.getInjury();
						}
						check = true;
					}	
					break;
				default:
					System.out.println("��J�ݲM��");
			}
		}
		 
	}
	public int getDamage(){
		return this.damage;
	}
	
	
	
}
