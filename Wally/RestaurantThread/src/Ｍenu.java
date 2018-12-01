
public enum Ｍenu {

	HAMBURGER(13,23),
	PIZZA(18,30) ,
	FRENCH_FRIES(6,11) ,
	CHICKEN_NUGGETS(8,13) ,
	CHICKEN_LEG(25,40) ;
	
	private int cookingTime;
	private int mealPrice;
	
	Ｍenu(int cookingTime , int mealCost) {
		
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
