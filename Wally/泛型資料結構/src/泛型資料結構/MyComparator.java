package 泛型資料結構;

import java.util.Comparator;

public class MyComparator implements Comparator<Student> {
	
	public MyComparator() {
	}
	
	public int compare(Student s1 ,Student s2) {
	// 返數負值為兩數無法相比之情況
		try {	
			int studentNumber1 = s1.getStudentNumber() ; 
			int studentNumber2 = s2.getStudentNumber();
			
			return studentNumber1 - studentNumber2 ;			
		} catch (NullPointerException npe) {
			return -1 ;
		}
	}	
}
