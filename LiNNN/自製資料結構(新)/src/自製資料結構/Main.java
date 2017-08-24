package �ۻs��Ƶ��c;

import java.util.Comparator;

import Exception.StackEmptyException;

public class Main {

	public static void main (String[] args) {
        Comparator<Student> myComparator = new MyComparator();
		LinStack<Student> myStack = new LinStack<Student>(myComparator);  //�ŧi

        try{
                for ( int i = 0 ; i < 9 ; i ++ )  //��J1~10 �ǥ�
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
