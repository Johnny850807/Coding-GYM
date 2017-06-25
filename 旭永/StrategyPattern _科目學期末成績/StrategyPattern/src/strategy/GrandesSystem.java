package strategy;

public class GrandesSystem {
	
	Total_grandes totalgrandes;
	
	
		//獲取總成績  ,應該能改進這寫法
		public double getTotalGrandes(double Attend,double Homework,
				double MidtermTest,double FinalTest)
		{
			return totalgrandes.get_TotalGrandes(Attend,Homework,MidtermTest,FinalTest);
		}
		
		
		
		
		//動態設定項目
		public void setSubject(Total_grandes totalgrandes){
			this.totalgrandes=totalgrandes;
		}
		

}
