package ¾Ç¥Í;

public class Student {
	int height;
	int weight;
	int grades;
	String id;
	public void setHeight(int h) {
		height=h;
	}
	public void setWeight(int w) {
		weight=w;
	}
	public void setGrades(int g) {
		grades=g;
	}
	public void setId(String i) {
		id=i;
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
