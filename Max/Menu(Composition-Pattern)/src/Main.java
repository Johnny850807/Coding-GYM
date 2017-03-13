import java.util.*;

public class Main {
	public static void main(String[] args){
		List<SellFood> list = new ArrayList<SellFood>();
		
		SellFood First = new ManyFoodStore("一餐");
		SellFood Second = new ManyFoodStore("二餐");
		SellFood Third = new ManyFoodStore("三餐");
		SellFood McDonald = new FoodStore("麥當勞");
		
		list.add(First);
		list.add(Second);
		list.add(Third);
		list.add(McDonald);
		
		SellFood Family = new FoodStore("全家便利商店");
		SellFood DumplingsStore = new FoodStore("餃子店");
		SellFood BreakfastStore = new FoodStore("早餐店");
		SellFood SeafoodStore = new FoodStore("海產店");
		
		First.add(Family);
		Second.add(DumplingsStore);
		Second.add(SeafoodStore);
		Third.add(BreakfastStore);
		
		SellFood Beverage = new FoodMenu("飲料類");
		SellFood Toast = new FoodMenu("吐司類");
		SellFood Dumpling = new FoodMenu("餃子類");
		SellFood FastFried = new FoodMenu("快炒類");
		
		SellFood SpicyDumpling = new FoodItem("辣味餃");
		SellFood RedDumpling = new FoodItem("紅水餃");
		SellFood ToastEgg = new FoodItem("吐司蛋");
		SellFood ToastMeet = new FoodItem("吐司肉");
		SellFood MilkTea = new FoodItem("奶茶");
		SellFood BlackTea = new FoodItem("紅茶");
		SellFood Beer = new FoodItem("酒");
		SellFood GoldenFish = new FoodItem("金魚");
		SellFood FriedRice = new FoodItem("炒飯");
		
		McDonald.add(BlackTea);
		McDonald.add(ToastMeet);
		McDonald.add(ToastEgg);
		
		Family.add(Toast);
		Family.add(Beverage);
		DumplingsStore.add(Dumpling);
		SeafoodStore.add(Beverage);
		SeafoodStore.add(FastFried);
		BreakfastStore.add(Toast);
		BreakfastStore.add(Beverage);
		
		Toast.add(ToastEgg);
		Toast.add(ToastMeet);
		Beverage.add(MilkTea);
		Beverage.add(BlackTea);
		Beverage.add(Beer);
		Dumpling.add(SpicyDumpling);
		Dumpling.add(RedDumpling);
		FastFried.add(FriedRice);
		FastFried.add(GoldenFish);
		
		for (SellFood s : list){
			s.display(1);
			System.out.println();
		}
		
	
	}
}
