package Minner;

import java.util.Scanner;

public class Test {
	
	private static Scanner scanner;

	public static void main(String[] args) {
		Board board;
		scanner = new Scanner(System.in);
		int size = inputSize();
		int mineAmount = inputMineAmount(size);
		

		board = new Board(size,mineAmount);
		char continueGame;
		do
		{
			do
			{
				board.print();
				boolean available;  //��J�O�_�i��
				do
				{
					System.out.println("�п�J����ܮ�l�y��(y/x): ");
					int y = scanner.nextInt();
					int x = scanner.nextInt();
					available = board.makePlayerChoice(y, x);
				} while(!available);
			}while(!board.isGameOver());
			
			System.out.println("�O�_�n�A�Ӥ@��?(y/n): ");
			scanner.nextLine();  //��w�Ī�����Y��
			continueGame = scanner.nextLine().charAt(0);
			if ( continueGame == 'y' )
			{
				// ���s�C��
				size = inputSize();
				mineAmount = inputMineAmount(size);
				board.reset(size, mineAmount);
			}
				
		} while (continueGame == 'y');
	}

	
	static int inputSize(){
		int size;
		do
		{
			System.out.print("�п�J��a�p�j�p(1~10) :");
			size = scanner.nextInt();
			if (  size <= 0 || size > 12 )
				System.out.println("��J���~!!");
		} while ( size <= 0 || size > 12 );
		
		return size;
	}
	
	static int inputMineAmount(int size){
		int mineAmount;
		do
		{
			System.out.printf("�п�J�a�p�ƶq(1~%d) :",size*size-1);
			mineAmount = scanner.nextInt();
			if ( mineAmount <= 0 || mineAmount >= size*size )
				System.out.println("��J���~!!");
		} while ( mineAmount <= 0 || mineAmount >= size*size );
		
		return mineAmount;
		
	}
}
