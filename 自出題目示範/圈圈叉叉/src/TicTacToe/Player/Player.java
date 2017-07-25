package TicTacToe.Player;

import TicTacToe.Item.Team;

public abstract class Player {
	public final static char TEAM_CROSS = 'X';
	public final static char TEAM_CIRCLE = 'O';
	private String name;
	private Team team;
	
	public Player(){
		name = createName();
	}

	protected abstract String createName();
	
	public abstract int makeChoice();
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

	@Override
	public String toString() {
		return name;
	}
	
	
}
