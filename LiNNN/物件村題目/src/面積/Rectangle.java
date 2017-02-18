package 面積;

import java.util.Scanner;

public class Rectangle {
	
	public void Rectangle(){
		Scanner input = new Scanner(System.in);
		
		System.out.println("請輸入 長、寬:");
		
		double weight = input.nextDouble();
		double lenght = input.nextDouble();
		
		System.out.println("面積:"+weight*lenght);
		System.out.println();
	}

}
