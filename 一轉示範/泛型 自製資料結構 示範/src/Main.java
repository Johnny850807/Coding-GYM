import java.util.Comparator;
import java.util.Iterator;
import java.util.Random;

public class Main {

	public static void main(String[] args) {
		Comparator<Student> myComparator = new MyComparator();  //�ۻs Comparator
		WaterballStack<Student> myStack = new WaterballStack<Student>(myComparator);  //�ŧi

		try{
			for ( int i = 0 ; i < 10 ; i ++ )  //��J1~10�Ӿǥ�
				myStack.push(new Student(i));
		        
			for (Student student : myStack)  // for-each���X�L�X
				System.out.print(student + " ");
			
			System.out.println();
			
			while(true)  //�G�N�L�� pop ��Ĳ�o�ҥ~
			{
				Student nextStudent = myStack.pop();
				System.out.print(nextStudent + " ");  //�ݬݬO�_�򨫳X�����Ǥ@��
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
