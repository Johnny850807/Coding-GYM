package ²×·¥±K½X;

public abstract class Player {
	public int answer;
	public String name;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public abstract int generateNumber(int lowerBound, int upperBound);
}
