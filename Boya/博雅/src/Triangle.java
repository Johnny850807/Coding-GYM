import java.util.Scanner;

public class Triangle {

	void setTriangle() {
		float 底;
		float 高;
		Scanner scanner = new Scanner(System.in);

		System.out.println("請輸入三角形 : 底、高。");
		底 = scanner.nextFloat();
		高 = scanner.nextFloat();
		System.out.println((底 * 高) / 2);
	}
}
