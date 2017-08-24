package 自製資料結構;

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
		return "學生編號[" + this.number + "] ";
	}
	
}
