package 菜單;

import java.util.ArrayList;

public class Main {
	public static void main(String[] argv)
	{
		Location[] locations = new Location[5];//測試
		Shop[] shops = new Shop[5];//測試
		Food[] foods = new Food[5];//測試
		
		//一餐
		foods[0] = new Food("番茄義大利麵");
		foods[1] = new Food("焗烤起司麵");
		ArrayList<Item> temp1 = new ArrayList<Item>();
		temp1.add(foods[0]);
		temp1.add(foods[1]);
		shops[0] = new Shop("義大利麵餐館",temp1);
		
		foods[0] = new Food("鐵板牛肉");
		foods[1] = new Food("鐵板豬");
		ArrayList<Item> temp2 = new ArrayList<Item>();
		temp2.add(foods[0]);
		temp2.add(foods[1]);
		shops[1] = new Shop("鐵板餐管",temp2);
		
		ArrayList<Item> temp3 = new ArrayList<Item>();
		temp3.add(shops[0]);
		temp3.add(shops[1]);
		locations[0] = new Location("一餐",temp3);
		System.out.print(locations[0].print());
		
		//二餐
		
		/*foods[0] = new Food("原味餃子");
		foods[1] = new Food("咖哩餃子");
		temp1 = new ArrayList<Item>();
		temp1.add(foods[0]);
		temp1.add(foods[1]);
		shops[0] = new Shop("八方雲集",temp1);
		
		temp2 = new ArrayList<Item>();
		shops[1] = new Shop("全家");
		
		
		temp3 = new ArrayList<Item>();
		locations[1] = new Location("二餐");
		System.out.println(locations[1].print());*/
	}
}
