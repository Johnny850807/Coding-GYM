package ���n;

import java.util.Scanner;

public class Triangle {

	public void Triangle(){
		Scanner input = new Scanner(System.in);
		
		System.out.println("�п�J ���B��:");
		
		double base = input.nextDouble();
		double height = input.nextDouble();
		
		System.out.println("���n:"+base*height/2);
		System.out.println();
	}
}
