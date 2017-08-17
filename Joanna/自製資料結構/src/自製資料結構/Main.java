package �ۻs��Ƶ��c;

import java.util.Comparator;

public class Main {
	
	public static void main(String[] args) {
		
		class MyComparator implements Comparator<Student> {

    		@Override
    		public int compare(Student student1, Student student2) {
    			return student1.getNumber() - student2.getNumber();
    		}
    		
    	}
		
		Comparator<Student> myComparator = new MyComparator();  //�ۻs Comparator
        DataStack<Student> myStack = new DataStack<Student>(myComparator);  //�ŧi

        try{
                for ( int i = 0 ; i < 10 ; i ++ )  //��J1~10 �ǥ�
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

}
