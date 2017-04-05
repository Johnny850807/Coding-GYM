package polymorphism_test;
import java.util.Random;
import java.util.Scanner;

public class evenAI extends AI{
	

	evenAI(String name){
		this.name=name;
	}
	
	
	void guess() {
		
		
		Random evenAI = new Random();
		guessnumber=evenAI.nextInt(StartGame.max)+StartGame.min;
		
		
		

		
		while(guessnumber%2 != 1 ||guessnumber>=StartGame.max ||	guessnumber<=StartGame.min){
				
			guessnumber=evenAI.nextInt(StartGame.max)+StartGame.min;
		
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