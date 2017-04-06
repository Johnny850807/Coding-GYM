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
	
	public float getHeight() {
		return height;
	}
	public void setHeight() {
		System.out.println("請輸入身高 :");
		do
		{
		this.height = Student.setNumbers();
		if	(this.height > 250 )
			System.out.println("請重新輸入身高 :");
		}while(this.height > 250 );
		// 假設巨人症最多生長到250光年
	}
	public float getWeight() {
		return weight;
	}
	public void setWeight() {
		System.out.println("請輸入體重  :");
		do
		{
		this.weight = Student.setNumbers();
		if	(this.weight > 300 )
			System.out.println("請重新輸入體重 :");
		}while(this.weight > 300 );
		// 假設體重計受力最多300公斤重
	}
	public float getGrades() {
		return grades;
	}
	public void setGrades() {
		System.out.println("請輸入成績 :");
		do
		{
		this.grades = Student.setNumbers();
		if	(this.grades > 100)
			System.out.println("請重新輸入成績 :");
		}while(this.grades > 100 );
		// 假如學生不靠作弊最多能考100分
	}
	public int getId() {
		return id;
	}
	public void setId() {
		System.out.println("請輸入學號 :");
		this.id = (int)Student.setNumbers() ;
		// 您儘管輸入字串,能成功算我輸
	}
}