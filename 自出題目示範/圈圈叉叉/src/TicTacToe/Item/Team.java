package TicTacToe.Item;

public enum Team {
	NONE('-'), CIRCLE('O'), CROSS('X');
	
	private char sign;
	private Team(char sign){
		this.sign = sign;
	}
	@Override
	public String toString() {
		return String.valueOf(sign);
	}
	
	
}
