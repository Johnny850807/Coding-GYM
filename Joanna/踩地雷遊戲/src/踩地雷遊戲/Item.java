package ½ò¦a¹p¹CÀ¸;

public class Item {
	private boolean isLandmine;
	private boolean isOpen;
	private int nearbyLandmineAmount;
	
	public Item() {
		super();
		isLandmine = false;
		isOpen = false;
		nearbyLandmineAmount = 0;
	}

	public boolean isLandmine() {
		return isLandmine;
	}
	
	public void setLandmine(boolean isLandmine) {
		this.isLandmine = isLandmine;
	}
	
	public int getNearbyLandmineAmount() {
		return nearbyLandmineAmount;
	}
	
	public void setNearbyLandmineAmount(int nearbyLandmineAmount) {
		this.nearbyLandmineAmount = nearbyLandmineAmount;
	}

	public boolean isOpen() {
		return isOpen;
	}

	public void setOpen(boolean isOpen) {
		this.isOpen = isOpen;
	}
	
	public void displayLandmine() {
		if (isLandmine())
			System.out.print("1 ");
		else 
			System.out.print("0 ");
	}
	
	public void displayNearbyLandmineAmount(boolean isOver) {
		if (!isOver) {
			if(isOpen())
				System.out.print(getNearbyLandmineAmount() + " ");
			else
				System.out.print("- ");
		}
		else {
			if (isLandmine())
				System.out.print("* ");
			else 
				System.out.print(getNearbyLandmineAmount() + " ");
		}
	}
	
}
