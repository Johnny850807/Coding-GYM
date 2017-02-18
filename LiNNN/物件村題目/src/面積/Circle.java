package 面積;

import java.util.Scanner;

public class Circle {

	public void Circle(){
		Scanner input = new Scanner(System.in);
		
		System.out.println("請輸入 半徑:");
		
		double radius = input.nextDouble();
		
		System.out.println("面積:"+radius*radius*3.14);
		System.out.println();
	}
	
}
