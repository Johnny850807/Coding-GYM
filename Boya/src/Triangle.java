import java.util.Scanner;

public class Triangle {

	void setTriangle() {
		Shape Triangle = new Shape();
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("�п�J�T���� : ���B���C");
		Triangle.FirstLength = scanner.nextFloat();
		Triangle.SecondLength = scanner.nextFloat();
		Triangle.Area = (Triangle.FirstLength*Triangle.SecondLength)/2;
		
		System.out.println(Triangle.Area);
	}
}
