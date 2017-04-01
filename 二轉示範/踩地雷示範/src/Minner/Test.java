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
				boolean available;  //輸入是否可行
				do
				{
					System.out.println("請輸入欲選擇格子座標(y/x): ");
					int y = scanner.nextInt();
					int x = scanner.nextInt();
					available = board.makePlayerChoice(y, x);
				} while(!available);
			}while(!board.isGameOver());
			
			System.out.println("是否要再來一場?(y/n): ");
			scanner.nextLine();  //把緩衝的換行吃掉
			continueGame = scanner.nextLine().charAt(0);
			if ( continueGame == 'y' )
			{
				// 重新遊戲
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
			System.out.print("請輸入踩地雷大小(1~10) :");
			size = scanner.nextInt();
			if (  size <= 0 || size > 12 )
				System.out.println("輸入錯誤!!");
		} while ( size <= 0 || size > 12 );
		
		return size;
	}
	
	static int inputMineAmount(int size){
		int mineAmount;
		do
		{
			System.out.printf("請輸入地雷數量(1~%d) :",size*size-1);
			mineAmount = scanner.nextInt();
			if ( mineAmount <= 0 || mineAmount >= size*size )
				System.out.println("輸入錯誤!!");
		} while ( mineAmount <= 0 || mineAmount >= size*size );
		
		return mineAmount;
		
	}
}
