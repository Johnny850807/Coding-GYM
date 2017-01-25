package game;
import java.util.*;
public abstract class AI {
	//���Fabstract �� guessNumber() �~�䥦����l���i�Τ��ι�@ 
	protected guessNumber game = guessNumber.getInstance(); //�@�P�ɨ�
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
