import java.util.Scanner;

public class Main {
	public static void main(String[] args)
	{
	
		Scanner input = new Scanner(System.in);
		System.out.println("�п�J�ﶵ :\n(B or b):�k \0(G or g):�k  ");

		//�H�U�ŧi����P��X�ʧ@
		String actions = input.next() ;
		Human_Being man = new Man();
		Human_Being woman = new Woman();
		// ���O�Y��
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
		// �A�O��ı
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
