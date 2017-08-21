import java.util.ArrayList;
import java.util.List;

public class Main {

	
	public static void main(String[] args) {
		CompositeMenuList myMenuList = new CompositeMenuList("銘傳大學");
		
		MealsGettable firstRestaurant = new Building("一餐");
		MealsGettable secondRestaurant = new Building("二餐");
		MealsGettable bbNingVendor = new Vendor("BB阿甯路邊攤");
		MealsGettable yellowMom = new Vendor("黃媽媽");
		
		myMenuList.addItem(firstRestaurant);
		myMenuList.addItem(secondRestaurant);
		myMenuList.addItem(bbNingVendor);
		myMenuList.addItem(yellowMom);
		
		/*一餐*/
		
		MealsGettable italyVendor = new Vendor("義大利");
		italyVendor.addItem(new MenuItem("番茄義大利麵"));
		italyVendor.addItem(new MenuItem("焗烤起司麵"));
		
		MealsGettable ironVendor = new Vendor("鐵板餐管");
		ironVendor.addItem(new MenuItem("鐵板牛肉"))
		.addItem(new MenuItem("鐵板豬"));
		
		firstRestaurant.addItem(italyVendor).addItem(ironVendor);
		
		/*二餐*/
		
		MealsGettable eightSquare = new Vendor("八方雲集");
		eightSquare.addItem(new MenuItem("原味餃子")).addItem(new MenuItem("珈里餃子"));
		
		MealsGettable MyFamily = new Vendor("全家");
		
		MyFamily.addItem(new MenuCategory("甜點類")
				.addItem(new MenuItem("起司蛋糕"))
				.addItem(new MenuItem("蘋果麵包")))
		.addItem(new MenuCategory("微波類")
				.addItem(new MenuItem("牛肉炒麵"))
				.addItem(new MenuItem("豬肉蓋飯")));
		
		secondRestaurant.addItem(eightSquare).addItem(MyFamily);
		
		/*BB阿甯路邊攤*/
		
		bbNingVendor.addItem(new MenuCategory("現炒類")
				.addItem(new MenuItem("現炒鮑魚"))
				.addItem(new MenuItem("現場吉拿棒")))
		.addItem(new MenuCategory("酒類")
				.addItem(new MenuItem("威士忌"))
				.addItem(new MenuItem("台灣啤酒")));
		
		/*黃媽媽*/
		
		yellowMom.addItem(new MenuItem("豬肉蓋飯"))
		.addItem(new MenuItem("蛋包飯"))
		.addItem(new MenuItem("養樂多"));
		
		List<MealsGettable> list = myMenuList.toList();
		for (MealsGettable m : list)
			System.out.println(m);
	}

}
