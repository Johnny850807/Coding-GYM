import java.util.Scanner;

public class Rectangle {
	
	void setRectangle() {
		Shape Rectangle = new Shape();
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("�п�J�x�� : ���B�e�C");
		Rectangle.FirstLength = scanner.nextFloat();
		Rectangle.SecondLength = scanner.nextFloat();
		Rectangle.Area = Rectangle.FirstLength*Rectangle.SecondLength;
		
		System.out.println(Rectangle.Area);
	}

}
