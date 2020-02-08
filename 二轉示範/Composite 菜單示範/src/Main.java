import Composite.Building;
import Composite.MenuCategory;
import Composite.Meal;
import Composite.*;
public class Main {


	public static void main(String[] args) {
		College college = new College("銘傳大學");

		Building firstRestaurant = new Building("一餐");
		Building secondRestaurant = new Building("二餐");
		Vendor bbNingVendor = new Vendor("BB阿甯路邊攤");
		Vendor yellowMom = new Vendor("黃媽媽");

		college.addItem(firstRestaurant);
		college.addItem(secondRestaurant);
		college.addItem(bbNingVendor);
		college.addItem(yellowMom);

		/*一餐*/

		Vendor italyVendor = new Vendor("義大利");
		italyVendor.addItem(new Meal("番茄義大利麵"));
		italyVendor.addItem(new Meal("焗烤起司麵"));

		Vendor ironVendor = new Vendor("鐵板餐管");
		ironVendor.addItem(new Meal("鐵板牛肉"))
				.addItem(new Meal("鐵板豬"));

		firstRestaurant.addItem(italyVendor).addItem(ironVendor);

		/*二餐*/

		Vendor eightSquare = new Vendor("八方雲集");
		eightSquare.addItem(new Meal("原味餃子")).addItem(new Meal("珈里餃子"));

		Vendor MyFamily = new Vendor("全家");

		MyFamily.addItem(new MenuCategory("甜點類")
				.addItem(new Meal("起司蛋糕"))
				.addItem(new Meal("蘋果麵包")))
				.addItem(new MenuCategory("微波類")
						.addItem(new Meal("牛肉炒麵"))
						.addItem(new Meal("豬肉蓋飯")));

		secondRestaurant.addItem(eightSquare).addItem(MyFamily);

		/*BB阿甯路邊攤*/

		bbNingVendor.addItem(new MenuCategory("現炒類")
				.addItem(new Meal("現炒鮑魚"))
				.addItem(new Meal("現場吉拿棒")))
				.addItem(new MenuCategory("酒類")
						.addItem(new Meal("威士忌"))
						.addItem(new Meal("台灣啤酒")));

		/*黃媽媽*/

		yellowMom.addItem(new Meal("豬肉蓋飯"))
				.addItem(new Meal("蛋包飯"))
				.addItem(new Meal("養樂多"));


		for (MenuItem m : college)
			System.out.println(m);
	}

}