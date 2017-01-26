import java.util.Scanner;

public class Rectangle {

	void setRectangle() {
		float 長;
		float 寬;
		Scanner scanner = new Scanner(System.in);

		System.out.println("請輸入矩形 : 長、寬。");
		長 = scanner.nextFloat();
		寬 = scanner.nextFloat();
		System.out.println(長 * 寬);
	}

}
