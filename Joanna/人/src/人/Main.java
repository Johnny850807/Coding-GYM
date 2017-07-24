package ¤H;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static void main(String [] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("¿é¤J¦r¦ê");
		String inputString = input.next();
		ArrayList<Human> human = new ArrayList<Human>();
		for(int i = 0 ; i < inputString.length(); i++) {
			Man b = new Man();
			Woman g = new Woman();
			if( inputString.charAt(i) == 'b' || inputString.charAt(i) == 'B' )
				human.add(b);
			else if( inputString.charAt(i) == 'g' || inputString.charAt(i) == 'G' )
				human.add(g);
		}
		for(int i = 0; i < human.size(); i++ ) {
			human.get(i).eat();
		}
		for( int i = 0 ; i < human.size() ; i++ ) {
			human.get(i).sleep();
		}
	}
}
