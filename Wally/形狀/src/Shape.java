import java.util.Scanner;

public class Shape 
{	
	public int product ;

	public static final double PI = 3.14159 ;
	
	public Shape(){
		this(0,0);		
	}
	public Shape(int radius){
		this(radius,radius) ;	
	}
	public Shape(int length , int width ){
		setArea( length , width ) ;
	}
	public void setArea ( int length , int width ){
		product = length*width ;
	}
	public static void main (String[] args)
	{
		int bottom = 0 ;
		int height = 0 ;
		int length = 0 ;
		int width = 0 ;
		int radius = 0 ;
		Scanner scanner = new Scanner (System.in);
		System.out.println("請輸入想計算的圖形 :\n(1)三角形  (2) 矩形 (3) 圓形");
		String input = scanner.next();	
		switch ( input )
		{
		case "1" :
			System.out.println("你選擇了三角形\n請輸入底和高");
			do
			{
				bottom = scanner.nextInt();
				height = scanner.nextInt();
			}while(bottom < 1 || height < 1 ) ;
			Shape triangle = new Shape(bottom,height);
			System.out.println((float)(triangle.product)/2);
		break ;

		case "2" :
			System.out.println("你選擇了矩形\n請輸入長跟寬");
			do
			{
				length = scanner.nextInt();
				width = scanner.nextInt();
			}while(length < 1 || width < 1 ) ;
			Shape rectangle = new Shape(length,width);
			System.out.println(rectangle.product);
		break ;
		
		case "3" :
			System.out.println("你選擇了圓形\n請輸入半徑");	
			do
			{
				radius = scanner.nextInt();
			}while( radius < 1 ) ;
			Shape round = new Shape(radius);
			System.out.println((int)(round.product*Shape.PI));
		break ;
		
		default :
		System.out.println(" Can't find ");
		}
	}
}