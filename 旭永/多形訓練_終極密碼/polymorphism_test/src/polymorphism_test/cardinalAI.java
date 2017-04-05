package polymorphism_test;
import java.util.Random;
import java.util.Scanner;

public class cardinalAI extends AI{

	cardinalAI(String name){
		this.name=name;
	}
	
	void guess() {
		
		
		Random cardinalAI = new Random();
		guessnumber=cardinalAI.nextInt(StartGame.max)+StartGame.min;
		
		

		
		while(guessnumber%2 != 0 || guessnumber>=StartGame.max || guessnumber<=StartGame.min){
			
			
				guessnumber=cardinalAI.nextInt(StartGame.max)+StartGame.min;
				
				if(guessnumber==StartGame.password){
					break;
				}
			
				
		}

	
	}

	@Override
	int getguessnumber() {
		return guessnumber;
		
	}

	
	
}