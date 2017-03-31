package org.nyngwang.area;

import java.util.Scanner;

public class Main {
	public static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
		while (true) {
			System.out.println("Enter the number which you want to compute the area");
			System.out.print("(1) Triangle (2) Rectangle (3) Circle ? ");
			switch (scan.nextInt()) {
			case 1:
				Triangle triangle = new Triangle();
				System.out.print("Base: ");
				triangle.setBase(scan.nextDouble());
				System.out.print("Height: ");
				triangle.setHeight(scan.nextDouble());
				System.out.println("Area of triangle: " + triangle.getArea());
				break;
			case 2:
				Rectangle rectangle = new Rectangle();
				System.out.print("Width: ");
				rectangle.setWidth(scan.nextDouble());
				System.out.print("Height: ");
				rectangle.setHeight(scan.nextDouble());
				System.out.println("Area of rectangle: " + rectangle.getArea());
				break;
			case 3:
				Circle circle = new Circle();
				System.out.print("Radius: ");
				circle.setRadius(scan.nextDouble());
				System.out.println("Area of circle: " + circle.getArea());
				break;
			default:
				System.out.println("What do u mean?");
			}
		}
	}
}
