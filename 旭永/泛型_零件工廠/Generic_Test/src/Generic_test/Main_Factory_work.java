package Generic_test;

import java.util.Scanner;

public class Main_Factory_work {

	public static void main(String[] args) {
		
		System.out.println("===================�s��u�t�}�l�B�@===================");
		Factory<Screw,Robot> f=new Factory<>();
		
		
		//�s������T�w��,�����]�s��ƶq
		Scanner sc=new Scanner(System.in);
		System.out.println("��J�ݭn���s��ƶq:");
		int Components_count=sc.nextInt();
				
		for(int i=0 ; i < Components_count ; i++ ){
			f.addComponents(new Screw());
		}
		
		System.out.println("===================�s��s�@����===================");		
		
		
		try {
			
			System.out.println("===================�}�l�s�@���~===================");			
			
			
			f.product(new Robot());
		} catch (ComponentsNotEnough e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
