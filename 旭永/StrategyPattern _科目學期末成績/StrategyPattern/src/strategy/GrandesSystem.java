package strategy;

public class GrandesSystem {
	
	Total_grandes totalgrandes;
	
	
		//����`���Z  ,���ӯ��i�o�g�k
		public double getTotalGrandes(double Attend,double Homework,
				double MidtermTest,double FinalTest)
		{
			return totalgrandes.get_TotalGrandes(Attend,Homework,MidtermTest,FinalTest);
		}
		
		
		
		
		//�ʺA�]�w����
		public void setSubject(Total_grandes totalgrandes){
			this.totalgrandes=totalgrandes;
		}
		

}
