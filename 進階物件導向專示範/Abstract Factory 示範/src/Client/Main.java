package Client;

import Client.Role.*;

public class Main {
	static Role[] roles = new Role[]{
			new Hero() , new Sans()
	};
	public static void main(String[] args) {
		int turn = 0;  // the index to specify whose turn is it now.
		do
		{
			roles[turn].printInfo();
			roles[turn].doAttackAction( roles[turnNumber(turn)] );
			turn = turnNumber(turn);
		}while(!gameOver());
		
		printResult();
	}
	
	static int turnNumber(int num){
		return num == 0 ? 1 : 0;
	}
	
	static boolean gameOver(){
		for ( Role r : roles )
			if ( r.isDead() )
				return true;
		return false;
	}
	
	static void printResult(){
		if (roles[0].isDead())
			System.out.println("Well you failed..");
		else
			System.out.println("Incredible winner ! ");
	}

}
