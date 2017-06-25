import java.util.Scanner;

public class Student{
	// 身高 體重 成績 學號
	private float height ;
	private float weight ;
	private float grades ;
	private int id ;
	
	public static Scanner input = new Scanner(System.in);
	
	public static float setNumbers () {
	
	float number ;
	do
	{
		number = input.nextFloat();
	}	while( number < 1 ) ;	
		return number ;
	}
	public void setInformations() {
		do
		{
		System.out.println("請輸入身高 體重  成績  學號:");	
		this.height = Student.setNumbers();
		this.weight = Student.setNumbers();
		this.grades = Student.setNumbers();
		this.id = (int)Student.setNumbers() ;
		}while(this.height > 250 || this.weight > 300 || this.grades > 100);
	}
	public void getInformations() {
		System.out.println("身高是: "+this.height+" 體重是: "+this.weight+" 成績是: "+this.grades+" 學號是: "+this.id);
	}
	public float getHeight() {
		return height;
	}
	public float getWeight() {
		return weight;
	}
	public float getGrades() {
		return grades;
	}
	public int getId() {
		return id;
	}
}