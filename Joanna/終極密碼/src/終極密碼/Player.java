package ²×·¥±K½X;

public abstract class Player {
	protected int answer;
	protected String name;
	
	public Player() {
        name = nameSelf();
    }
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	protected abstract int generateNumber(int lowerBound, int upperBound);
	protected abstract String nameSelf();
}
