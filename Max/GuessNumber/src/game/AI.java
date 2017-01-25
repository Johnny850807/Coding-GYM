package game;
import java.util.*;
public abstract class AI {
	//除了abstract 的 guessNumber() 外其它的兒子都可用不用實作 
	protected guessNumber game = guessNumber.getInstance(); //共同享受
	protected playerType type; 
	protected String name;
	protected int id;
	public AI(playerType type , String name){
		this.type = type;
		this.name = name;
		
	}
	public playerType getType() {
		return type;
	}
	public void setType(playerType type) {
		this.type = type;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public abstract int guessNumber(int l , int h);
	
}
