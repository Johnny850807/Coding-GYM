
public class ManyFoodStore extends SellFood{
	
	public ManyFoodStore(String name){
		super(name);
	}
	public void printSub(int depth){
		for (SellFood s:sellList){
			s.display(depth);
		}
	}
	
	
}
