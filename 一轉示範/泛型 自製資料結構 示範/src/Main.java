import java.util.Comparator;
import java.util.Iterator;
import java.util.Random;

public class Main {

	public static void main(String[] args) {
		Comparator<Student> myComparator = new MyComparator();  //自製 Comparator
		WaterballStack<Student> myStack = new WaterballStack<Student>(myComparator);  //宣告

		try{
			for ( int i = 0 ; i < 10 ; i ++ )  //放入1~10個學生
				myStack.push(new Student(i));
		        
			for (Student student : myStack)  // for-each走訪印出
				System.out.print(student + " ");
			
			System.out.println();
			
			while(true)  //故意無限 pop 來觸發例外
			{
				Student nextStudent = myStack.pop();
				System.out.print(nextStudent + " ");  //看看是否跟走訪的順序一樣
			}
	        
		}catch(StackEmptyException err){
			System.out.println(err.getMessage());
		}

	}
	
	private static Student createNewStudent() {
		Random random = new Random();
		return new Student(random.nextInt(100));
	}

	static class MyComparator implements Comparator<Student>{
		@Override
		public int compare(Student o1, Student o2) {
			return o1.getId() - o2.getId();
		}
		
	}
 
}
