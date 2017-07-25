package TicTacToe.Player;

import TicTacToe.Item.Board;
import TicTacToe.Item.Team;

//神話級 電腦 不敗傳說 水球AI
public class WaterballAI extends AI{

	public WaterballAI(Board board) {
		super(board);
	}

	@Override
	public int makeChoice() {
		return minMaxAlgorithm();
	}
	
	private int minMaxAlgorithm(){
		int choice = -99;
		int maxScore = -99;
		
		for ( int i = 0 ; i < 3 ; i ++ )
			for ( int j = 0 ; j < 3 ; j ++ )
			{
				if (!board.getBlocks()[i][j].hasOwner())
				{
					Board newBoard = board.clone();
					newBoard.getBlocks()[i][j].setTeam(this.getTeam());
					int score = minMaxAlgorithm(newBoard, this.getTeam());
					if ( maxScore < score )
					{
						maxScore = score;
						choice = i*3+j+1;
					}
				}
			}
		return choice;
	}
	
	private int minMaxAlgorithm(Board status, Team team){
		int score = 0;
		int minScore = 99;
		int maxScore = -99;
		if (status.isGameOver())
			{
				Team resultteam = status.getWinTeam();
				if ( resultteam == Team.NONE)
					return 0;
				if ( resultteam == this.getTeam())
					return 1;
				return -1;
			}
		Team nextTeam = nextTeam(team); 
		
		for ( int i = 0 ; i < 3 ; i ++ )
			for ( int j = 0 ; j < 3 ; j ++ )
			{
				if ( !status.getBlocks()[i][j].hasOwner())
				{
					Board newBoard = status.clone();
					newBoard.getBlocks()[i][j].setTeam(nextTeam);
					score = minMaxAlgorithm(newBoard, nextTeam);
					minScore = minScore > score ? score : minScore;
					maxScore = maxScore < score ? score : maxScore;
				}
			}
		
		if ( nextTeam == this.getTeam())
			return maxScore;
		return minScore;
	}
	
	private Team nextTeam(Team team){
		return team == Team.CIRCLE ? Team.CROSS : Team.CIRCLE;
	}

}
