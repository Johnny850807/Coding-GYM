
public class FoodMenu extends SellFood{
	public FoodMenu(String name){
		super(name);
	}
	public void printSub(int depth){
		for(SellFood s : sellList){
			s.display(depth);
		}
	}
}
