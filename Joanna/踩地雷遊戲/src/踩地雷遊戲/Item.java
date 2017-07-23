package ½ò¦a¹p¹CÀ¸;

public class Item {
	private boolean isLandmine;
	private boolean isOpen;
	private int nearbyLandmineAmount;
	
	public Item() {
		super();
		setLandmine(false);
		setOpen(false);
		setNearbyLandmineAmount(0);
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
	

	
}
