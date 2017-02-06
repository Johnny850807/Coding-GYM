package Human;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	static List<Human> humanList = new ArrayList<Human>();
	public static void main(String[] args) {
		System.out.println("¿é¤J¦r¦ê¡G");
		String orderText = scanner.nextLine().trim();
		
		for ( int i = 0 ; i < orderText.length() ; i ++ )
		{
			if ( Character.toLowerCase(orderText.charAt(i)) == 'b')
				humanList.add(new Man());
			else
				humanList.add(new Woman());
		}

		for ( Human h : humanList )
			h.eat();
		for ( Human h : humanList )
			h.sleep();

	}

}
