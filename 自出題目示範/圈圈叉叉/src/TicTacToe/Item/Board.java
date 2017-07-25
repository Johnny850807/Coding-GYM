package TicTacToe.Item;

import TicTacToe.Item.Exception.BlockHasBeenChosenException;
import TicTacToe.Item.Exception.NumberOutOfBoundException;
import TicTacToe.Item.Exception.TicTacToeException;
import TicTacToe.Player.Player;

//盤面
public class Board implements Item{
	private Block[][] blocks = new Block[3][3]; 
	
	public Board(){
		initBlocks(this.getBlocks());
	}
	
	public void initBlocks(Block[][] blocks){
		for ( int i = 0 ; i < 3 ; i ++ )
			for ( int j = 0 ; j < 3 ; j ++ )
				blocks[i][j] = new Block();
	}
	
	@Override
	public void print() {
		for ( int i = 0 ; i < 3 ; i ++ )
		{
			for ( int j = 0 ; j < 3 ; j ++ )
				blocks[i][j].print();
			System.out.print("\n\n");
		}
	}
	
	public void makeChoice(Player owner, int number) throws TicTacToeException {
		if (number <= 0 || number > 9)
			throw new NumberOutOfBoundException();
		Block block = blocks[(number-1)/3][(number-1)%3];
		if (block.hasOwner()) //如果該格子已經有玩家佔領，則拋出例外
			throw new BlockHasBeenChosenException();
		block.setTeam(owner.getTeam());
	}
	
	public boolean isGameOver(){
		if ( hasWinner() )
			return true;
		for ( int i = 0 ; i < 3 ; i ++ )
			for ( int j = 0 ; j < 3 ; j ++ )
				if (!blocks[i][j].hasOwner())
					return false;
		return true;
	}
	
	public boolean hasWinner(){
		return getWinTeam() != Team.NONE;
	}
	
	public Team getWinTeam(){
		for ( int i = 0 ; i < 3 ; i ++ )  //比對行
			if ( blocks[0][i].getTeam() != Team.NONE && blocks[0][i].getTeam() == blocks[1][i].getTeam() && blocks[1][i].getTeam() == blocks[2][i].getTeam())
				return blocks[0][i].getTeam();
		
		for ( int i = 0 ; i < 3 ; i ++ )  //比對列
			if ( blocks[i][0].getTeam() != Team.NONE && blocks[i][0].getTeam() == blocks[i][1].getTeam() && blocks[i][1].getTeam() == blocks[i][2].getTeam())
				return blocks[i][0].getTeam();
		
		//斜排
		if ( blocks[0][0].getTeam() != Team.NONE && blocks[0][0].getTeam() == blocks[1][1].getTeam() && blocks[1][1].getTeam() == blocks[2][2].getTeam())
			return blocks[0][0].getTeam();
		
		if ( blocks[0][2].getTeam() != Team.NONE && blocks[0][2].getTeam() == blocks[1][1].getTeam() && blocks[1][1].getTeam() == blocks[2][0].getTeam())
			return blocks[0][2].getTeam();
		
		return Team.NONE;
	}
	
	public void clear(){
		initBlocks(blocks);
	}
	
	public Block[][] getBlocks(){
		return blocks;
	}
	
	public Board clone() {
		Board newBoard = new Board();
		for ( int i = 0 ; i < 3 ; i ++ )
			for ( int j = 0 ; j < 3 ; j ++ )
				newBoard.getBlocks()[i][j].setTeam(this.blocks[i][j].getTeam());

		return newBoard;
	}

}
