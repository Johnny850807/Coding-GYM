import java.util.*;

public class Main {
	
	public static void main(String[] args) {
		ArrayList<Human> humans = new ArrayList<Human> ();
		inputSex(humans);
		printlnDoSomething(humans);
	}
	
	
	static void inputSex(ArrayList<Human> humans) {
		Scanner scanner = new Scanner(System.in);
		String input;
		input = scanner.next();
		input = input.toUpperCase();
		for(int i = 0 ; i < input.length(); i++) {
			switch(input.charAt(i)) {
				case 'B':
					humans.add(new Man());
					break;
				case 'G':
					humans.add(new Woman());
					break;
				default:
					continue;
			}
		}
	}
	
	
	static void printlnDoSomething(ArrayList<Human> humans) {
		for(Human human : humans) 
			human.eat();
		
		for(Human human : humans)
			human.sleep();
	}

}
