import java.util.ArrayList;
import java.util.List;

public class Random {

	List arr = new ArrayList();
	
	public void random() {
		int ran = 0;
		
		while ( arr.size() < 4 ) {    /*size()�o�O����"��k"*/
			ran = (int) (Math.random() * 10);
			
			if( arr.indexOf(ran) == -1 ) {      /*indexOf�^�ǲĤ@��ch�r�������ޭ�*/
				     /*�]��rnd���٨S���s�Jans�̭��A�ҥH�䤣��ans�̪�rnd�]�Ӷ�-1*/
				arr.add(ran);
			}
		}
		System.out.println(arr);
		
	}
	
}
