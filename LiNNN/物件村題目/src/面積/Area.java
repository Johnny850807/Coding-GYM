package ���n;

import java.util.Scanner;

public class Area {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		
		int B = 1;	
		
		while(B == 1) {
			System.out.println(" �п�ܭn�p�⪺�Ϊ� 1.�T���� 2.�x�� 3.��� 4.���} ");
			int number = input.nextInt();
		
			switch(number) {
				case 1:
					Triangle t = new Triangle();
					t.Triangle();
					break;
				case 2:
					Rectangle r = new Rectangle();
					r.Rectangle();
					break;
				case 3:
					Circle c = new Circle();
					c.Circle();
					break;
				case 4:
					B = 0;
					System.out.println("Exit...");
					break;
			}
		}
		
	}

}
