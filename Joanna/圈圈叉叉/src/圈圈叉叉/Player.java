package °é°é¤e¤e;

public abstract class Player {
	protected String name;
	protected char symbol;
	
	public Player() {
		super();
		name = nameSelf();
	}
	
	public String getName() {
		return name;
	}
	
	public char getSymbol() {
		return symbol;
	}

	public void setSymbol(char symbol) {
		this.symbol = symbol;
	}

	public abstract int chooseBlockNumber(Board board);
	protected abstract String nameSelf();
}
