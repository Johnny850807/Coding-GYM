package 泛型資料結構;

public class Student {

	private int studentNumber ;
	
	public Student() {
	}
	
	public Student( int num ) {
		setStudentNumber(num);
	}
	
	public int getStudentNumber() {
		return studentNumber;
	}
	
	public void setStudentNumber(int studentNumber) {
		this.studentNumber = studentNumber;
	}
	
	@Override
	public String toString() {
		return ""+ studentNumber;
	}
	
}
