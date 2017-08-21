package °é°é¤e¤e;

public class Block {
	private char symbol;
	private boolean wasSelected;
	
	public Block() {
		wasSelected = false;
	}

	public char getSymbol() {
		return symbol;
	}

	public void setSymbol(char symbol) {
		wasSelected = true;
		this.symbol = symbol;
	}

	public boolean wasSelected() {
		if (symbol >= 48 && symbol <= 57)
			wasSelected = false;
		else
			wasSelected = true;
		return wasSelected;
	}
	
}
