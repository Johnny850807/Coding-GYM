package �ۻs��Ƶ��c;

public class Student {

	private int number;

	public Student(int i) {
		this.number = i;
	}

	public int getNumber() {
		return number;
	}
	
	@Override
	public String toString() {
		return "�ǥͽs��[" + this.number + "] ";
	}
	
}
