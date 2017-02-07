
public class Ground {
	private boolean isMine;
	private int countMine;
	private boolean checkOpen;
	
	public boolean isMine() {
		return isMine;
	}
	public void setMine(boolean isMine) {
		this.isMine = isMine;
	}
	
	public int getRoundMine() {
		return countMine;
	}
	public void addRoundMine(int mine) {
		countMine += mine;
	}
	public void setRoundMine(int mine){
		countMine = mine;
	}
	
	public boolean isOpen(){
		return checkOpen;
	}
	public void setOpen(boolean open){
		checkOpen = open;
	}
	public void printGround(){
		System.out.print(countMine);
	}
	
}
