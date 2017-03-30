package org.nyngwang.composite;

public class Main {
	public static void main(String[] args) {
		Place firstRestaurant = new FirstRestaurant();
		Place spaghettiHut = new SpaghettiHut();
		spaghettiHut.add(new TomatoSpaghetti());
		spaghettiHut.add(new BakedRoastedPasta());
		Place hotPlateNoodlesHut = new HotPlateNoodlesHut();
		hotPlateNoodlesHut.add(new BeefHotPlateNoodles());
		hotPlateNoodlesHut.add(new PorkHotPlateNoodles());
		firstRestaurant.add(spaghettiHut);
		firstRestaurant.add(hotPlateNoodlesHut);
		System.out.println(firstRestaurant.whatIveThought());
	}
}
