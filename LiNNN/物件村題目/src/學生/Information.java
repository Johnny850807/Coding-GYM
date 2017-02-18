package ¾Ç¥Í;

public class Information {

	double height;
	double weight;
	int grades;
	String id;
	
	public Information(double height, double weight, int grades, String id){
		this.height = height;
		this.weight = weight;
		this.grades = grades;
		this.id = id;
	}
	
	public String toString() {
		return "[ Student Height:" + height + "CM Weight:" + weight + "KG Grades:" + grades + "Point Id: " + id + "]";  
	}
	
}
