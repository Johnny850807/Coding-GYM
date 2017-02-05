import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class MealsGettable {
	protected String typeName;
	protected String selfName;
	protected List<MealsGettable> menuList =  Collections.checkedList( 
			new ArrayList<MealsGettable>() , MealsGettable.class );
	
	public MealsGettable(String typeName , String selfName){
		this.typeName = typeName;
		this.selfName = selfName;
	}
	
	/**呼叫此方法來印出菜單分類名稱與內容**/
	public void printSelfAndItems(){
		System.out.printf("%s: %s%n",typeName,selfName);
		printSubItems();
	}
	
	/**根據每個子類別菜單印內容**/
	protected abstract void printSubItems();
	
	
	public MealsGettable addItem(MealsGettable subItem){
		menuList.add(subItem);
		return this;
	}
}
