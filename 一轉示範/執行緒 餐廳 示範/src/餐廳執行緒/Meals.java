package À\ÆU°õ¦æºü;

public enum Meals {
	HAMBURGER(13, "º~³ù", 23), 
	PIZZA(18, "©ÜÂÄ", 30), 
	FRENCHFRIED(6, "Á¦±ø", 11), 
	CHICKEN_NUGGET(8, "Âû¶ô", 13), 
	CHICKEN_LEG(25, "Âû»L", 40);
	
	public int timeCost; // in seconds
	public int price;
	public String name;
	

	private Meals(int timeCost, String name,  int price) {
		this.timeCost = timeCost;
		this.price = price;
		this.name = name;
	}


	@Override
	public String toString() {
		return name;
	}
}