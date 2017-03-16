import java.util.Random;

public class Monster {
	private int monsterHp;
	
	public Monster(){
		randomHp();
	}
	public void randomHp(){
		monsterHp = (int) (Math.random()*10000 + 3000) ;
	}
	public void beAttacked(int damage){
		monsterHp -= damage;
	}
	public int getMonsterHp(){
		return monsterHp;
	}

}
