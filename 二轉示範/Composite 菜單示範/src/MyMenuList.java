import java.util.ArrayList;



class MyMenuList < T extends MealsGettable >{
	
	/***�ۭq�x�� �iŪ�ʸ���@�ʦӤw***/
	
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
	