package �ۻs��Ƶ��c;

public class Student {
	
	private int number;
	
	public int getNumber() {
		return number;
	}

	public Student(int number) {
		this.number = number;
	}
	
	@Override
	public String toString() {
	    return "�ǥͽs��(" + getNumber() + ")";
	}
	
}
