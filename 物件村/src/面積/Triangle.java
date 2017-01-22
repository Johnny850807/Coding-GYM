package 面積;

import java.util.Scanner;

public class Triangle {
	Scanner input = new Scanner(System.in);
	public void show(){
		System.out.print("輸入底邊");
		float bottom=(float) input.nextInt();
		System.out.print("輸入高");
		float high=(float) input.nextInt();
		System.out.println("三角形面積為 "+bottom*high*0.5);
	}
	

}
