
public class Monster {
	private int hp;
	public Monster(int hp){
		this.hp = hp;
	}
	
	public void getInjured(int injury){
		hp = hp - injury < 0 ? 0 : hp - injury;
	}
	
	public boolean isDead(){
		return hp == 0;
	}

	public int getHp() {
		return hp;
	}
	
	
}
