package 自製資料結構;

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
	    return "學生編號(" + getNumber() + ")";
	}
	
}
