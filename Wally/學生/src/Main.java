import java.util.Scanner;

public class Main{
	
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
		Student exchange = new Student();
		for ( i = 0 ; i < amount ; i ++ )
			{
				students[i] = new Student();
				System.out.println("第"+(i+1)+"個學生 :");
				students[i].setInformations(); // 設定全部學生資料
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
				students[i].getInformations(); // 取得全部學生資料 , 如要取得單獨資料 , 可打 students[第幾個學生-1].某個資料
			}
	}	
	
}