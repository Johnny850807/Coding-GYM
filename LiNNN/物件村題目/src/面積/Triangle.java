package 面積;

import java.util.Scanner;

public class Triangle {

	public void Triangle(){
		Scanner input = new Scanner(System.in);
		
		System.out.println("請輸入 底、高:");
		
		double base = input.nextDouble();
		double height = input.nextDouble();
		
		System.out.println("面積:"+base*height/2);
		System.out.println();
	}
}
