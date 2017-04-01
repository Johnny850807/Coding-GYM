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
	
	/**�I�s����k�ӦL�X�������W�ٻP���e**/
	public void printSelfAndItems(){
		System.out.printf("%s: %s%n",typeName,selfName);
		printSubItems();
	}
	
	/**�ھڨC�Ӥl���O���L���e**/
	protected abstract void printSubItems();
	
	
	public MealsGettable addItem(MealsGettable subItem){
		menuList.add(subItem);
		return this;
	}
}
