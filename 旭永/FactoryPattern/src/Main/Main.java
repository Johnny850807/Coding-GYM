package Main;
import java.util.Scanner;

import Bullet.Bullet;
import factory.MachineBulletFatory;
import Gun.*;

public class Main {

	public static void main(String[] args) 
	{
		
		//�S�B�z����
		monster m=new monster();
		hero hero=new hero();
	
		do{
			System.out.println("�Ǫ���q"+m.HP());
			int damage= hero.acctack();
			m.gethurt(damage);
			
		}while(!m.isdead());
		
	}

}
