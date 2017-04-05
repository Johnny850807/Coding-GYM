package polymorphism_test;

import java.util.Random;
import java.util.Scanner;

public class FinalCode_Main {
	 static int password;

     static int max=100;
     static int min=1;

     
    static  Player[] player;
     
	public static void main(String[] args) {
		
		StartGame game=new StartGame();
		game.init();
		game.gamestart();
	

	}

}
