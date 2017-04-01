package 物件村學生排序;

public class Student {
	private int height;
	private int weight;
	private int grades;
	private String id;
	
	
	public Student(int height, int weight, int grades, String id) {
		super();
		this.height = height;
		this.weight = weight;
		this.grades = grades;
		this.id = id;
	}
	
	
	
	
	@Override
	public String toString() {
		return "Student [height=" + height + ", weight=" + weight + ", grades=" + grades + ", id=" + id + "]";
	}


	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public int getGrades() {
		return grades;
	}
	public void setGrades(int grades) {
		this.grades = grades;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	
}
