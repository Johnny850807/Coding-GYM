import java.util.ArrayList;



class MyMenuList < T extends MealsGettable >{
	
	private ArrayList<T> menuList = new ArrayList<T>();
	
	public MyMenuList add(T t){
		menuList.add(t);
		return this;
	}

	public void printAllMenu(){
		for ( T t : menuList )
			t.printSelfAndItems();
	}
		
	
}
	