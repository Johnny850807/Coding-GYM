package Generic_test;

import java.util.Scanner;

public class Main_Factory_work {

	public static void main(String[] args) {
		
		System.out.println("===================零件工廠開始運作===================");
		Factory<Screw,Robot> f=new Factory<>();
		
		
		//零件種類固定後,直接設零件數量
		Scanner sc=new Scanner(System.in);
		System.out.println("輸入需要的零件數量:");
		int Components_count=sc.nextInt();
				
		for(int i=0 ; i < Components_count ; i++ ){
			f.addComponents(new Screw());
		}
		
		System.out.println("===================零件製作完成===================");		
		
		
		try {
			
			System.out.println("===================開始製作產品===================");			
			
			
			f.product(new Robot());
		} catch (ComponentsNotEnough e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
