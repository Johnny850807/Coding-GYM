import java.util.Scanner;

public class Rectangle {
	
	void setRectangle() {
		Shape Rectangle = new Shape();
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("請輸入矩形 : 長、寬。");
		Rectangle.FirstLength = scanner.nextFloat();
		Rectangle.SecondLength = scanner.nextFloat();
		Rectangle.Area = Rectangle.FirstLength*Rectangle.SecondLength;
		
		System.out.println(Rectangle.Area);
	}

}
