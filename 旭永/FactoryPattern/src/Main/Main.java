package Main;
import java.util.Scanner;

import Bullet.Bullet;
import factory.MachineBulletFatory;
import Gun.*;

public class Main {

	public static void main(String[] args) 
	{
		
		//沒處理角色
		monster m=new monster();
		hero hero=new hero();
	
		do{
			System.out.println("怪物血量"+m.HP());
			int damage= hero.acctack();
			m.gethurt(damage);
			
		}while(!m.isdead());
		
	}

}
