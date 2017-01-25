import java.util.Scanner;

public class Main {
	public static void main(String[] argv) {
		
		float choice;
		while(true){
			System.out.println("(1) 三角形 (2) 矩形 (3) 圓形");
			Scanner scanner = new Scanner(System.in);
			choice = scanner.nextFloat();
	
			if (choice == 1) {
				Triangle Create = new Triangle();
				Create.setTriangle();
				
			} else if (choice == 2) {
				Rectangle Create = new Rectangle();
				Create.setRectangle();
				
			} else if (choice == 3) {
				Circular Create = new Circular();
				Create.setCircular();
			}
		}
			
	}
}