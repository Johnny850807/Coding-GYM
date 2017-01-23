package Minner;

import java.util.Random;

public class Board implements MinnerItem{
	private Block[][] blocks;
	private int mineAmount;  //地雷數量
	private int size;
	private boolean gameOver; //踩到地雷遊戲結束
	
	public Board(int size , int mineAmount){
		reset(size,mineAmount);
	}
	
	public void reset(int size , int mineAmount){
		//設置
		this.mineAmount = mineAmount;
		this.size = size;
		initialize();
		randomlyCreatingMines();
		countMinesAmountBesideEachBlock();
		gameOver = false;
	}
	
	public void initialize(){
		//初始化
		int temp = mineAmount;
		blocks = new Block[size][size];
		
		for ( int i = 0 ; i < size ; i ++ )
			for ( int j = 0 ; j < size ; j ++ )
				blocks[i][j] = new Block();
	}
	
	public void randomlyCreatingMines(){
		//隨機產生地雷
		Random rand = new Random();
		int temp = mineAmount;  //應放置地雷數量
		
		while (temp != 0)
		{ 
			int x = rand.nextInt(size);
			int y = rand.nextInt(size);
			if ( !blocks[y][x].isMine() )  //若非地雷才可設置
			{
				blocks[y][x].setMine(true);
				temp --;
			}
		}
	}
	
	public void countMinesAmountBesideEachBlock(){
		//算周遭地雷
		int count;
		
		for ( int i = 0 ; i < size ; i ++ )
			for ( int j = 0 ; j < size ; j ++ )
			{
				count = 0;
				for ( int k = i - 1 ; k <= i + 1  ; k ++ )
					for ( int m = j - 1 ; m <= j + 1 ; m ++ )
					{
						if ( k < 0 || k >= size || m < 0 || m >= size)
							continue;
						if (blocks[k][m].isMine() )
							count ++;
					}
				blocks[i][j].setNumOfMines(count);
			}
	}

	@Override
	public void print() {
		// 印出所有格子
		System.out.print("   ");
		for ( int i = 0 ; i < size ; i ++ )  
		{
			if ( i >= 10 )
				System.out.print(i + " ");
			else
				System.out.print(i + "  ");
		}
			
		for ( int i = 0 ; i < size ; i ++ )
		{
			System.out.println();
			if ( i >= 10 )
				System.out.print(i + " ");
			else
				System.out.print(i + "  ");
			
			for ( int j = 0 ; j < size ; j ++ )
			{
				blocks[i][j].print();  // composite
				System.out.print("  ");
			}		
		}
		System.out.println();
	}
	
	public boolean makePlayerChoice(int y , int x){
		//傳入遊戲者選擇座標 ，回傳該位子是否可供選擇
		
		if ( y < 0 || x < 0 || y > size || x > size )
			return false;
		if ( blocks[y][x].isOpened() )
			return false;
		
		openBlock(y,x);
		return true;
	}
	
	public void openBlock( int y , int x){
		blocks[y][x].setOpened(true);
		if (blocks[y][x].isMine())
		{
			gameOver = true;
			allSetOpened();
			print();
			System.out.println("====== 踩到地雷了 !!!! 遊戲結束  ======");
			
		}
			
	}
	
	public void allSetOpened(){
		//開啟所有格子
		for ( int i = 0 ; i < size ; i ++ )
			for ( int j = 0 ; j < size ; j ++ )
				blocks[i][j].setOpened(true);
	}

	public boolean isGameOver() {
		return gameOver;
	}

	public void setGameOver(boolean gameOver) {
		this.gameOver = gameOver;
	}

	
}
