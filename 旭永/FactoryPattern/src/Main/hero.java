package Main;

import java.util.Scanner;

import Gun.*;
import Gun.MachineGun;
import factory.ExplosionBullrFactory;
import factory.MachineBulletFatory;

public class hero {
	
	
	public int acctack(){
		Scanner sc= new Scanner(System.in);
		System.out.println("��Z��");
		int choose = sc.nextInt();
		
		//�S�B�z��J�ˬd
		Gun g = null;
		switch (choose){
		
		case 0:
			 g = new MachineGun(new MachineBulletFatory().createBullet());
			g.shot();
			break;

		case 1:
			 g = new ExplosionGun(new ExplosionBullrFactory().createBullet());
			break;

		case 2:
			 g = new MachineGun(new MachineBulletFatory().createBullet());
			break;
		
		}
		
		return g.getSumDamage();
	}

}
