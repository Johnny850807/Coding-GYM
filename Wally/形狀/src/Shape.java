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
		System.out.println("請輸入想計算的圖形 :\n(1)三角形  (2) 矩形 (3) 圓形");
		String input = scanner.next();	
		switch ( input.charAt(0) )
		{
		case '1' :
			System.out.println("你選擇了三角形\n請輸入底和高");
			do
			{
				bottom = scanner.nextFloat();
				height = scanner.nextFloat();
			}while(bottom < 1 || height < 1 ) ;
			Shape triangle = new Shape(input.charAt(0),bottom,height);
			System.out.println(triangle.constant);
		break ;

		case '2' :
			System.out.println("你選擇了矩形\n請輸入長跟寬");
			do
			{
				length = scanner.nextFloat();
				width = scanner.nextFloat();
			}while(length < 1 || width < 1 ) ;
			Shape rectangle = new Shape(input.charAt(0),length,width);
			System.out.println((int)rectangle.constant);
		break ;
		
		case '3' :
			System.out.println("你選擇了圓形\n請輸入半徑");	
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