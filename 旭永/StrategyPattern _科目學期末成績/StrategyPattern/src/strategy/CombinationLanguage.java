package strategy;

public class CombinationLanguage implements Total_grandes{

	
	private static CombinationLanguage combinationLanguage;
	
	private CombinationLanguage(){}
		
	
	
	@Override
	public double get_TotalGrandes(double Attend, double Homework, double MidtermTest, double FinalTest) {
		
		
		double total,UsualGrades;
			
		
		UsualGrades = Attend*0 + Homework*0;	
		total = UsualGrades +  MidtermTest*0 + FinalTest*1;
		
		System.out.println("組合語言 -- 學期總成績"+total);
		return 	total;
	}
	
	
	
	
	//練習singleton
	public static CombinationLanguage getInstance(){
		if(combinationLanguage == null){
			combinationLanguage=new CombinationLanguage();
		}
		
		return combinationLanguage;
	}

}
