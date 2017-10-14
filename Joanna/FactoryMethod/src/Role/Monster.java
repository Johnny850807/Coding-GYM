package Role;

public class Monster {

	private int healthPoint;
	
	public Monster(int healthPoint) {
		this.healthPoint = healthPoint;
	}
	
	public void decreaseHealthPoint(int damage) {
		healthPoint -= damage;
	}

	public int getHealthPoint() {
		return healthPoint;
	}
	
}
