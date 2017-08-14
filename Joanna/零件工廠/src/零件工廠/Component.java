package ¹s¥ó¤u¼t;

public abstract class Component {
	
	protected int componentAmount = 0;
	
	public int getComponentAmount() {
		return componentAmount;
	}

	public int increaseComponentAmount(int amount) {
		componentAmount += amount;
		return componentAmount;
	}
	
	public boolean consumeComponents(int amount) {
		if (componentAmount - amount >= 0) {
			componentAmount -= amount;
			return true;
		}
		else 
			return false;
	}
	
}
