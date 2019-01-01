
public enum Menu {

	漢堡(13,23),
	披薩(18,30) ,
	薯條(6,11) ,
	雞塊(8,13) ,
	雞腿(25,40) ;
	
	private int cookingTime;
	private int mealPrice;
	
	Menu(int cookingTime , int mealCost) {
		
		this.cookingTime = cookingTime*1000 ;
		this.mealPrice = mealCost ;
	}
	public int getCookingTime() {	
		return cookingTime;
	}
	public int getMealPrice() {	
		return mealPrice;
	}
}
