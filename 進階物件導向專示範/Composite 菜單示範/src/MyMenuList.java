import java.util.ArrayList;



class MyMenuList < T extends MealsGettable >{
	
	/***自訂泛型 可讀性跟維護性而已***/
	
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
	