package strategy;

public class English implements Total_grandes{

	private static English english;
	
	private English(){}
		
	

	
	
	@Override
	public double get_TotalGrandes(double Attend, double Homework, double MidtermTest, double FinalTest) {
		
		double total,UsualGrades;
	
		UsualGrades = Attend*(4.0/25.0) + Homework*(6.0/25.0);	
		total = UsualGrades +  MidtermTest*(3.0/10.0) + FinalTest*(3.0/10.0);
		
	
		System.out.println("�^�� -- �Ǵ��`���Z"+total);
		return 	total;
	}

	
	
	//�m��singleton
	public static English getInstance(){
		if(english == null){
			english=new English();
		}
		
		return english;
	}
	
	
}
