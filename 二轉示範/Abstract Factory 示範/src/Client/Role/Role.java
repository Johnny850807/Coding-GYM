package Client.Role;

import java.util.Scanner;

import Client.Factory.*;
import Weapon.Attackable;
import Weapon.Weapon;
import Weapon.Attack.*;
import Weapon.Defense.*;
import Weapon.MagicPower.*;

public abstract class Role {
	protected Scanner scanner = new Scanner(System.in);
	
	protected String name;
	protected int hp;
	protected int mp;
	protected AttackWeapon attackWeapon;
	protected DefenseWeapon defenseWeapon;
	protected MagicPower magicPower;
	
	public Role(){
		setupProperties();
	}
	
	private void setupProperties(){
		name = initName();
		hp = initHp();
		mp = initMp();
		WeaponsFactory factory = initFactory();
		attackWeapon = factory.getAttackWeapon();
		defenseWeapon = factory.getDefenseWeapon();
		magicPower = factory.getMagicPower();
	}
	
	protected abstract String initName();
	protected abstract int initHp();   
	protected abstract int initMp();   
	protected abstract WeaponsFactory initFactory();
	
	public void beInjured(int injury){
		int turnsOutInjury = getInjuryThroughDefense(injury);
		hpLosingFromInjury(turnsOutInjury);
	}
	
	protected void hpLosingFromInjury(int injury){
		hp = hp - injury < 0 ? 0 : hp - injury;
	}
	
	protected int getInjuryThroughDefense(int injury){
		int defense = defenseWeapon.getDefense();
		injury = injury - defense < 0 ? 0 : injury - defense;
		System.out.println(injury);
		return injury;
	}
	
	public void beMagicInjured(int injury){
		int turnsOutInjury = getInjuryThroughMagicDefense(injury);
		hp = hp - injury < 0 ? 0 : hp - injury;
	}
	
	protected int getInjuryThroughMagicDefense(int injury){
		int defense = defenseWeapon.getMagicDefense();
		return injury - defense < 0 ? 0 : injury - defense;
	}
	
	public void doAttackAction(Role attackedRole){
		Attackable attackChoice = toMakeChoice();	
		System.out.printf("%s 使用  %s 進行攻擊 !!%n" , name , attackChoice.getName() );
		delay(1000);

		injuringRoleByAttackChoice(attackedRole , attackChoice);
		loseMp( attackChoice.getLoseMp() );
		
		delay(1000);
	}
	
	protected abstract Attackable toMakeChoice();
	
	private void injuringRoleByAttackChoice(Role role , Attackable attackChoice){
		int repeat = attackChoice.getReaptedTimes();
		for ( int i = 0 ; i < repeat ; i ++ )
		{
			int injury = attackChoice.getInjury();
			role.beInjured(injury);
			delay(200);
		}
	}
	
	private void loseMp(int abatement){
		mp = mp - abatement < 0 ? 0 : mp - abatement;
	}
	
	private void delay(int times){
		try {
			Thread.sleep(times);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void printInfo(){
		System.out.printf("輪到 %s .... %n" , name);
		System.out.printf("狀態 : Hp %d , Mp %d %n" , hp , mp);
	}
	
	protected boolean isMpEnoughToUseMagic(){
		return mp >= magicPower.getLoseMp();
	}

	public boolean isDead(){
		return hp <= 0;
	}

	public int getHp() {
		return hp;
	}

	public String getName() {
		return name;
	}

	public AttackWeapon getAttackWeapon() {
		return attackWeapon;
	}

	public DefenseWeapon getDefenseWeapon() {
		return defenseWeapon;
	}

	public MagicPower getMagicPower() {
		return magicPower;
	}
	
	
}
