package polymorphism_test;

import java.util.Scanner;

public class Human extends Player{
	
	Human(String name){
		this.name=name;
	}
	
	

	@Override
	void guess() {

		Scanner humanguess =new Scanner(System.in);
		
		guessnumber=humanguess.nextInt();

	while(guessnumber>=StartGame.max || guessnumber<=StartGame.min){
			
		System.out.println("½d³ò¿ù»~, ½Ð­«²q");
		guessnumber=humanguess.nextInt();
		
	}
	
	}



	@Override
	int getguessnumber() {
		// TODO Auto-generated method stub
		return guessnumber;
	}
	
	


	

}
