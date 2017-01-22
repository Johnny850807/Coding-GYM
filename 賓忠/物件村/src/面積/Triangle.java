package ­±¿n;

import java.util.Scanner;

public class Triangle extends Shape{
	Scanner input = new Scanner(System.in);
	public void show(){
		float bottom=(float) input.nextDouble();
		float high=(float) input.nextDouble();
		System.out.println(bottom*high*0.5);
	}

}
