package member.nyngwang.area;

import java.util.Scanner;

public class Main {
	public static Scanner scan = new Scanner(System.in);
	
	// Constants for options
	public static final int TRIANGLE = 1;
	public static final int RECTANGLE = 2;
	public static final int CIRCLE = 3;
	
	public static void main(String[] args) {
		
		while (true) {
			System.out.println("Compute the area of shape (enter a number): "
					+ "(1)Triangle (2)Rectangle (3)Circle.");
			
			int answer = 0;
			System.out.print("Your answer: "); answer = scan.nextInt();
			
			switch (answer) {
				case TRIANGLE:
					Triangle triangle = new Triangle();
					System.out.print("Base: "); triangle.setBase(scan.nextDouble());
					System.out.print("Height: "); triangle.setHeight(scan.nextDouble());
					System.out.println("Area of triangle: " + triangle.getArea());
					break;
					
				case RECTANGLE:
					Rectangle rectangle = new Rectangle();
					System.out.print("Width: "); rectangle.setWidth(scan.nextDouble());
					System.out.print("Height: "); rectangle.setHeight(scan.nextDouble());
					System.out.println("Area of rectangle: " + rectangle.getArea());
					break;
					
				case CIRCLE:
					Circle circle = new Circle();
					System.out.print("Radius: "); circle.setRadius(scan.nextDouble());
					System.out.println("Area of circle: " + circle.getArea());
					break;
					
				default:
					System.out.println("Not an option.");
					
			}
			System.out.println();
			
		}
		
	}
	
}
