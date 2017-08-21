import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public abstract class MealsGettable implements Iterable<MealsGettable>{
	protected String typeName;
	protected String selfName;
	protected List<MealsGettable> menuList =  Collections.checkedList( 
			new ArrayList<MealsGettable>() , MealsGettable.class );
	
	public MealsGettable(String typeName , String selfName){
		this.typeName = typeName;
		this.selfName = selfName;
	}
	
	public void printSelfAndItems(){
		System.out.printf("%s: %s%n",typeName,selfName);
		printSubItems();
	}
	
	protected abstract void printSubItems();
	
	@Override
	public String toString() {
		return String.format("%s: %s%n",typeName,selfName);
	}
	
	
	public MealsGettable addItem(MealsGettable subItem){
		menuList.add(subItem);
		return this;
	}
	

	public Iterator<MealsGettable> iterator() {
		return toList().iterator();
	}
	
	public List<MealsGettable> toList() {
		List<MealsGettable> list = new ArrayList<>();
		list.add(this);
		for (MealsGettable m : menuList)
			list.addAll(m.toList());
		return list;
	}
	
}
