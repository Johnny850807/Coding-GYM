package �Ϊ�;
import java.util.Scanner;
public class Shape {
	public static void main(String [] args) {
		Scanner input=new Scanner(System.in);
		System.out.println("�n�p���اΪ������n?(��J�Ʀr)");
		System.out.println("1.�T���� 2.�x�� 3.���");
		int x=input.nextInt();
		if(x==1) {
			Triangle triangle=new Triangle();
			System.out.print("��=");
			triangle.bottom=input.nextInt();
			System.out.print("��=");
			triangle.height=input.nextInt();
			triangle.getArea();
			System.out.println("���n="+triangle.area);
		}
		else if(x==2) {
			Rectangle rectangle=new Rectangle();
			System.out.print("��=");
			rectangle.length=input.nextInt();
			System.out.print("�e=");
			rectangle.width=input.nextInt();
			rectangle.getArea();
			System.out.println("���n="+rectangle.area);
		}
		else if(x==3) {
			Circle circle=new Circle();
			System.out.print("�b�|=");
			circle.radius=input.nextInt();
			circle.getArea();
			System.out.println("���n="+circle.area);
		}
		else
			System.out.println("��J���~");
	}
}
