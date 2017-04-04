import java.util.Scanner;

public class Shape 
{	
	public double constant ;
	
	public Shape(){
		this('0',0,0);		
	}
	public Shape(float radius){
		this('3',radius,radius) ;	
	}
	public Shape(char option , float length , float width ){
		if	( option== '1' )
			constant = 0.5f ;
		else if ( option== '2' )
			constant = 1.0f ;
		else
			constant = 3.14f ;
		setArea( length , width ) ;
	}
	public void setArea ( float length , float width ){
		constant *= length*width ;
	} 
	public static void main (String[] args)
	{
		float bottom = 0 ;
		float height = 0 ;
		float length = 0 ;
		float width = 0 ;
		float radius = 0 ;
		Scanner scanner = new Scanner (System.in);
		System.out.println("�п�J�Q�p�⪺�ϧ� :\n(1)�T����  (2) �x�� (3) ���");
		String input = scanner.next();	
		switch ( input.charAt(0) )
		{
		case '1' :
			System.out.println("�A��ܤF�T����\n�п�J���M��");
			do
			{
				bottom = scanner.nextFloat();
				height = scanner.nextFloat();
			}while(bottom < 1 || height < 1 ) ;
			Shape triangle = new Shape(input.charAt(0),bottom,height);
			System.out.println(triangle.constant);
		break ;

		case '2' :
			System.out.println("�A��ܤF�x��\n�п�J����e");
			do
			{
				length = scanner.nextFloat();
				width = scanner.nextFloat();
			}while(length < 1 || width < 1 ) ;
			Shape rectangle = new Shape(input.charAt(0),length,width);
			System.out.println((int)rectangle.constant);
		break ;
		
		case '3' :
			System.out.println("�A��ܤF���\n�п�J�b�|");	
			do
			{
				radius = scanner.nextFloat();
			}while( radius < 1 ) ;
			Shape round = new Shape(radius);
			System.out.println((float)round.constant);
		break ;
		
		default :
		System.out.println(" Can't find ");
		}
	}
}