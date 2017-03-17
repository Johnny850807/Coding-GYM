import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {
	
	
	public static void main(String[] args) {
		Scanner input = new Scanner (System.in);
		
		List keyIn = new ArrayList();
		Random RD = new Random();
		Check CK = new Check();
		String num;
		int getA = 0;
		
		RD.random();
		
		Begin:
		while (getA < 4) {
		
			keyIn.clear();   /*清除列表中的所有元素*/
			System.out.println("Enter four digits number: ");
			num = input.next();
			
			if (num.length() != 4) {
				System.out.println("Is not a four digits number!!");
				continue Begin;
			}
			
			CK.check(keyIn,RD.arr);
		}

	}

}
