package strategy;

import java.util.Scanner;

public class Main_start {
	
	
	

	public static void main(String[] args) {
		
		double Attend,Homework,MidtermTest,FinalTest;
		Scanner sc=new Scanner(System.in); 
		
		//��J��إN�X�Φ��Z
		System.out.println("��ܭp���`���Z���: (1)��� (2)�^�� (3)�զX�y�� :");
			int SubjectCode=sc.nextInt();
		
		
		System.out.println("�X�u���Z");
			Attend=sc.nextDouble();
		
		System.out.println("�@�~���Z");
			Homework=sc.nextDouble();
		
		System.out.println("�������Z");
			MidtermTest=sc.nextDouble();
		
		System.out.println("�������Z");
			FinalTest=sc.nextDouble();
		
			
		
		
			//���Z�t��
			GrandesSystem grandesSystem=new GrandesSystem();

			//��إN�X
			switch(SubjectCode)
			{
				case 1:
					grandesSystem.setSubject(Chinese.getInstance());
					break;
				
				
				case 2:
					grandesSystem.setSubject(English.getInstance());
					break;
				
				
				case 3:
					grandesSystem.setSubject(CombinationLanguage.getInstance());
					break;
			}
			
			
			//��o�`���Z
			grandesSystem.getTotalGrandes(Attend, Homework, MidtermTest, FinalTest);
			
			
		
		
	}

}
