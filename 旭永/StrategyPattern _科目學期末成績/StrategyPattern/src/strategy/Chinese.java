package strategy;

public class Chinese implements Total_grandes{

	private static Chinese chinese;
	
	private Chinese(){}
		
	

	@Override
	public double get_TotalGrandes(double Attend,double Homework,double MidtermTest,double FinalTest) {
		//���o��妨�Z,��k
		
		double total,UsualGrades;
	
	
		
		UsualGrades = Attend*(6.0/50.0) + Homework*(7.0/25.0);	
		total = UsualGrades +  MidtermTest*(1.0/5.0) + FinalTest*(2.0/5.0);
		
		System.out.println("��� -- �Ǵ��`���Z"+total);
		
		return 	total;
	}
	
	
	//�m��singleton
	public static Chinese getInstance(){
		if(chinese == null){
			chinese=new Chinese();
		}
		
		return chinese;
	}


}
