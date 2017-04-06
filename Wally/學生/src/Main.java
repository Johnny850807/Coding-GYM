import java.util.Scanner;

public class Main{
	
	public static void Exchange ( float first , float second )
	{
		
		first = (int)first^(int)second ;
		second = (int)first^(int)second ;
		first = (int)first^(int)second ;
	}
	public static void main (String[] args )
	{
		int i , j ;
		float amount ;
		Scanner input = new Scanner(System.in);	
		do
		{
			System.out.println("請輸入有幾個學生 :");
			amount = input.nextFloat() ;
		}	while( amount < 1 ) ;
		Student students[]= new Student[(int)amount] ;
		
		for ( i = 0 ; i < amount ; i ++ )
			{
				students[i] = new Student();
				students[i].setHeight();
				students[i].setWeight();
				students[i].setGrades();
				students[i].setId();
			}
		if	( amount < 2 )
			for ( i = 0 ; i < amount ; i ++ )
				System.out.println("學生的身高是 : " + students[i].getHeight() + " 學生的體重是 : " + students[i].getWeight() + " 學生的成績是 : " + students[i].getGrades() + " 學生的學號是 : " + students[i].getId() ) ;
		else
			for ( i = 0 ; i < amount ; i ++ )
			{
				for ( j = i ; j < amount ; j ++ )
					{
						if	( students[i].getGrades() > students[j].getGrades() )
							{
								Exchange ( students[i].getHeight() , students[j].getHeight() ) ;
								Exchange ( students[i].getWeight() , students[j].getWeight() ) ;
								Exchange ( students[i].getGrades() , students[j].getGrades() ) ;
								Exchange ( students[i].getId()	   , students[j].getId() 	 ) ;
							}	
					
					}
				System.out.println("學生的身高是 : " + students[i].getHeight() + " 學生的體重是 : " + students[i].getWeight() + " 學生的成績是 : " + students[i].getGrades() + " 學生的學號是 : " + students[i].getId() ) ;
			}
	}	
	
}