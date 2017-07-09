package ¾Ç¥Í;

public class Student {
	private int height;
	private int weight;
	private int grades;
	private String id;
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Student(int height, int weight, int grades, String id) {
		super();
		this.height = height;
		this.weight = weight;
		this.grades = grades;
		this.id = id;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public void setGrades(int grades) {
		this.grades = grades;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getHeight() {
		return height;
	}
	public int getWeight() {
		return weight;
	}
	public int getGrades() {
		return grades;
	}
	public String getId() {
		return id;
	}
	public void print() {
		System.out.println("Student [height="+height+", weight="+weight+", grades="+grades+", id= "+id+"]");
	}
}
