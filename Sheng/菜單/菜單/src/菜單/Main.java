package ���;

import java.util.ArrayList;

public class Main {
	public static void main(String[] argv)
	{
		Location[] locations = new Location[5];//����
		Shop[] shops = new Shop[5];//����
		Food[] foods = new Food[5];//����
		
		//�@�\
		foods[0] = new Food("�f�X�q�j�Q��");
		foods[1] = new Food("�K�N�_�q��");
		ArrayList<Item> temp1 = new ArrayList<Item>();
		temp1.add(foods[0]);
		temp1.add(foods[1]);
		shops[0] = new Shop("�q�j�Q���\�]",temp1);
		
		foods[0] = new Food("�K�O����");
		foods[1] = new Food("�K�O��");
		ArrayList<Item> temp2 = new ArrayList<Item>();
		temp2.add(foods[0]);
		temp2.add(foods[1]);
		shops[1] = new Shop("�K�O�\��",temp2);
		
		ArrayList<Item> temp3 = new ArrayList<Item>();
		temp3.add(shops[0]);
		temp3.add(shops[1]);
		locations[0] = new Location("�@�\",temp3);
		System.out.print(locations[0].print());
		
		//�G�\
		
		/*foods[0] = new Food("�����l");
		foods[1] = new Food("�@����l");
		temp1 = new ArrayList<Item>();
		temp1.add(foods[0]);
		temp1.add(foods[1]);
		shops[0] = new Shop("�K�足��",temp1);
		
		temp2 = new ArrayList<Item>();
		shops[1] = new Shop("���a");
		
		
		temp3 = new ArrayList<Item>();
		locations[1] = new Location("�G�\");
		System.out.println(locations[1].print());*/
	}
}
