import java.util.ArrayList;
import java.util.List;

public class Random {

	List arr = new ArrayList();
	
	public void random() {
		int ran = 0;
		
		while ( arr.size() < 4 ) {    /*size()這是物件的"方法"*/
			ran = (int) (Math.random() * 10);
			
			if( arr.indexOf(ran) == -1 ) {      /*indexOf回傳第一個ch字元的索引值*/
				     /*因為rnd值還沒有存入ans裡面，所以找不到ans裡的rnd因而傳-1*/
				arr.add(ran);
			}
		}
		System.out.println(arr);
		
	}
	
}
