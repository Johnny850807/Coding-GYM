package 形狀;
import java.util.Scanner;
public class Shape {
	public static void main(String [] args) {
		Scanner input=new Scanner(System.in);
		System.out.println("要計算何種形狀的面積?(輸入數字)");
		System.out.println("1.三角形 2.矩形 3.圓形");
		int x=input.nextInt();
		if(x==1) {
			Triangle triangle=new Triangle();
			System.out.print("底=");
			triangle.bottom=input.nextInt();
			System.out.print("高=");
			triangle.height=input.nextInt();
			triangle.getArea();
			System.out.println("面積="+triangle.area);
		}
		else if(x==2) {
			Rectangle rectangle=new Rectangle();
			System.out.print("長=");
			rectangle.length=input.nextInt();
			System.out.print("寬=");
			rectangle.width=input.nextInt();
			rectangle.getArea();
			System.out.println("面積="+rectangle.area);
		}
		else if(x==3) {
			Circle circle=new Circle();
			System.out.print("半徑=");
			circle.radius=input.nextInt();
			circle.getArea();
			System.out.println("面積="+circle.area);
		}
		else
			System.out.println("輸入錯誤");
	}
}
