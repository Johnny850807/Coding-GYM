package Minner;

import java.util.Random;

public class Board implements MinnerItem{
	private Block[][] blocks;
	private int mineAmount;  //�a�p�ƶq
	private int size;
	private boolean gameOver; //���a�p�C������
	
	public Board(int size , int mineAmount){
		reset(size,mineAmount);
	}
	
	public void reset(int size , int mineAmount){
		//�]�m
		this.mineAmount = mineAmount;
		this.size = size;
		initialize();
		randomlyCreatingMines();
		countMinesAmountBesideEachBlock();
		gameOver = false;
	}
	
	public void initialize(){
		//��l��
		int temp = mineAmount;
		blocks = new Block[size][size];
		
		for ( int i = 0 ; i < size ; i ++ )
			for ( int j = 0 ; j < size ; j ++ )
				blocks[i][j] = new Block();
	}
	
	public void randomlyCreatingMines(){
		//�H�����ͦa�p
		Random rand = new Random();
		int temp = mineAmount;  //����m�a�p�ƶq
		
		while (temp != 0)
		{ 
			int x = rand.nextInt(size);
			int y = rand.nextInt(size);
			if ( !blocks[y][x].isMine() )  //�Y�D�a�p�~�i�]�m
			{
				blocks[y][x].setMine(true);
				temp --;
			}
		}
	}
	
	public void countMinesAmountBesideEachBlock(){
		//��P�D�a�p
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
		// �L�X�Ҧ���l
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
		//�ǤJ�C���̿�ܮy�� �A�^�ǸӦ�l�O�_�i�ѿ��
		
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
			System.out.println("====== ���a�p�F !!!! �C������  ======");
			
		}
			
	}
	
	public void allSetOpened(){
		//�}�ҩҦ���l
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
