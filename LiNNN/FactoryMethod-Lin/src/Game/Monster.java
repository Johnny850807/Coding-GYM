package Game;

public class Monster {

	private int hp;
	
	public Monster() {
		hp = (int)((Math.random() * 5000) + 5000);
	}
	
	public void getDamage(int damage) {
		hp -= damage;
		if (hp <= 0)
			hp = 0;
	}

	public int getHp() {
		return hp;
	}
	
	public boolean isDead() {
		return hp == 0 ? true : false; 
	}
	
}
