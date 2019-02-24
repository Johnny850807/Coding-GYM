package member.nyngwang.students;

public class Student {
	
	protected int height;
	protected int weight;
	protected int grade;
	protected String id;
	
	public Student(int height, int weight, int grade, String id) {
		this.height = height;
		this.weight = weight;
		this.grade = grade;
		this.id = id;
	}
	
	@Override
	public String toString() {
		return String.format("Student [height=%d, weight=%d, grade=%d, id=%s]",
				this.height, this.weight, this.grade, this.id);
	}
}
