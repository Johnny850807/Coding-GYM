
public class FoodStore extends SellFood{
	public FoodStore(String name){
		super(name);
	}
	public void printSub(int depth){
		for (SellFood s:sellList){
			s.display(depth);
		}
		
	}
}
