
public class Block {

	private boolean isChoose;
	private boolean isCircle;
	private boolean isCross;
	private String circle = "¡³   ";
	private String cross = "x   ";

	public Block() {
		super();
		isChoose = false;
		isCircle = false;
		isCross = false;
	}

	public boolean isChoose() {
		return isChoose;
	}

	public void setChoose(boolean isChoose) {
		this.isChoose = isChoose;
	}

	public boolean isCircle() {
		return isCircle;
	}

	public void setCircle(boolean isCircle) {
		this.isCircle = isCircle;
	}

	public boolean isCross() {
		return isCross;
	}

	public void setCross(boolean isCross) {
		this.isCross = isCross;
	}

	public void displayBlock(int i) {
		if (isChoose) {
			if (isCircle)
				System.out.print(circle);
			else 
				System.out.print(cross);
		} else {
			System.out.print(i + "   ");
		}
	}
	
	public void displayBlock() {
		if (isChoose) {
			if (isCircle)
				System.out.println(circle);
			else
				System.out.println(cross);
		} 
	}

}
