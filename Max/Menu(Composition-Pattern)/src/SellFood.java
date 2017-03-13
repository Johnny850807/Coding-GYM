import java.util.*;
public abstract class SellFood {
	protected List<SellFood> sellList = new ArrayList<SellFood>();
	protected String name;
	public SellFood(String name){
		this.name = name;
	}
	public void add(SellFood sellfood){
		sellList.add(sellfood);
	}
	public void remove(SellFood sellfood){
		sellList.remove(sellfood);
	}
	public void display(int depth){
		for(int i = 0 ; i < depth ; i++){
            System.out.print('-');
        }
		System.out.println(name);
		printSub(depth+2);
	}
	public abstract void printSub(int depth);
	
}
