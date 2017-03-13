import java.util.*;

public class Main {
	public static void main(String[] args){
		List<SellFood> list = new ArrayList<SellFood>();
		
		SellFood First = new ManyFoodStore("�@�\");
		SellFood Second = new ManyFoodStore("�G�\");
		SellFood Third = new ManyFoodStore("�T�\");
		SellFood McDonald = new FoodStore("�����");
		
		list.add(First);
		list.add(Second);
		list.add(Third);
		list.add(McDonald);
		
		SellFood Family = new FoodStore("���a�K�Q�ө�");
		SellFood DumplingsStore = new FoodStore("��l��");
		SellFood BreakfastStore = new FoodStore("���\��");
		SellFood SeafoodStore = new FoodStore("������");
		
		First.add(Family);
		Second.add(DumplingsStore);
		Second.add(SeafoodStore);
		Third.add(BreakfastStore);
		
		SellFood Beverage = new FoodMenu("������");
		SellFood Toast = new FoodMenu("�R�q��");
		SellFood Dumpling = new FoodMenu("��l��");
		SellFood FastFried = new FoodMenu("�֪���");
		
		SellFood SpicyDumpling = new FoodItem("������");
		SellFood RedDumpling = new FoodItem("������");
		SellFood ToastEgg = new FoodItem("�R�q�J");
		SellFood ToastMeet = new FoodItem("�R�q��");
		SellFood MilkTea = new FoodItem("����");
		SellFood BlackTea = new FoodItem("����");
		SellFood Beer = new FoodItem("�s");
		SellFood GoldenFish = new FoodItem("����");
		SellFood FriedRice = new FoodItem("����");
		
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
