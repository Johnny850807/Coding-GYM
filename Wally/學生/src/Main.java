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
			System.out.println("�п�J���X�Ӿǥ� :");
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
				System.out.println("�ǥͪ������O : " + students[i].getHeight() + " �ǥͪ��魫�O : " + students[i].getWeight() + " �ǥͪ����Z�O : " + students[i].getGrades() + " �ǥͪ��Ǹ��O : " + students[i].getId() ) ;
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
				System.out.println("�ǥͪ������O : " + students[i].getHeight() + " �ǥͪ��魫�O : " + students[i].getWeight() + " �ǥͪ����Z�O : " + students[i].getGrades() + " �ǥͪ��Ǹ��O : " + students[i].getId() ) ;
			}
	}	
	
}