import java.util.Scanner;

public class Main{
	
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
		Student exchange = new Student();
		for ( i = 0 ; i < amount ; i ++ )
			{
				students[i] = new Student();
				System.out.println("��"+(i+1)+"�Ӿǥ� :");
				students[i].setInformations(); // �]�w�����ǥ͸��
			}
		for ( i = 0 ; i < amount ; i ++ )
			{
				if	( amount > 1 )					
				for ( j = i ; j < amount ; j ++ )
					{
						if	( students[i].getGrades() > students[j].getGrades() )
							{
							exchange = students[i] ;
							students[i] = students[j] ;
							students[j] = exchange ;		
							}	
					
					}
				students[i].getInformations(); // ���o�����ǥ͸�� , �p�n���o��W��� , �i�� students[�ĴX�Ӿǥ�-1].�Y�Ӹ��
			}
	}	
	
}