import java.util.Scanner;

public class Circular {
	
	void setCircular() {
		DecimalFormat df=new DecimalFormat("#.##");
		Shape Circular = new Shape();
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("½Ð¿é¤J¶ê§Î : ¥b®|¡C");
		Circular.FirstLength = scanner.nextFloat();;
		Circular.Area = Circular.FirstLength*Circular.FirstLength*3.14;
		System.out.println(Circular.Area);
	}
}
