package TicTacToe.Item;

import TicTacToe.Player.Player;

//®æ¤l
public class Block implements Item{
	private static int BLOCK_AMOUNT = 1; 
	private int number;
	private Team team;
	
	public Block(){
		team = Team.NONE; 
		number = BLOCK_AMOUNT++;
		BLOCK_AMOUNT = BLOCK_AMOUNT > 9 ? 1 : BLOCK_AMOUNT;  //reset to 1
	}
	
	@Override
	public void print() {
		if (team == Team.NONE)
			System.out.print(" " + number + " ");
		else
			System.out.print(" " + team + " ");
	}


	public boolean hasOwner(){
		return team != Team.NONE;
	}
	
	public Team getTeam(){
		return team;
	}
	
	public void setTeam(Team team){
		this.team = team;
	}

}
