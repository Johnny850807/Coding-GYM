import java.util.Scanner;

public class Main {
	public static void main(String[] args)
	{
	
		Scanner input = new Scanner(System.in);
		System.out.println("請輸入選項 :\n(B or b):男 \0(G or g):女  ");

		//以下宣告物件與輸出動作
		String actions = input.next() ;
		Human_Being man = new Man();
		Human_Being woman = new Woman();
		// 先是吃飯
		for	(int i = 0; i < actions.length(); i++) 
		{
			switch (actions.charAt(i))
			{
				case 'B':
				case 'b':	
				((Man)man).eat();
				break;

				case 'G':
				case 'g':	
				((Woman)woman).eat();
				break;
				default:
				break;
			}
		}
		// 再是睡覺
		for	(int i = 0; i < actions.length(); i++) 
		{
			switch (actions.charAt(i))
			{
				case 'B':
				case 'b':	
				((Man)man).sleep();
				break;

				case 'G':
				case 'g':	
				((Woman)woman).sleep();
				break;
				default:
				break;
			}
		}
	}
}
