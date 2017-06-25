package strategy;

import java.util.Scanner;

public class Main_start {
	
	
	

	public static void main(String[] args) {
		
		double Attend,Homework,MidtermTest,FinalTest;
		Scanner sc=new Scanner(System.in); 
		
		//輸入科目代碼及成績
		System.out.println("選擇計算總成績科目: (1)國文 (2)英文 (3)組合語言 :");
			int SubjectCode=sc.nextInt();
		
		
		System.out.println("出席成績");
			Attend=sc.nextDouble();
		
		System.out.println("作業成績");
			Homework=sc.nextDouble();
		
		System.out.println("期中成績");
			MidtermTest=sc.nextDouble();
		
		System.out.println("期末成績");
			FinalTest=sc.nextDouble();
		
			
		
		
			//成績系統
			GrandesSystem grandesSystem=new GrandesSystem();

			//科目代碼
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
			
			
			//獲得總成績
			grandesSystem.getTotalGrandes(Attend, Homework, MidtermTest, FinalTest);
			
			
		
		
	}

}
