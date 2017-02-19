import java.util.Scanner;

public class ProgramTest {

	public static void main(String[] args) {
	
		Scanner input = new Scanner(System.in);
		
		Human sex = new Human();
		Man m = new Man();
		Woman w = new Woman();
		
		System.out.println("Input: ");
		String str1 = input.nextLine();
		
		sex.setSex(str1);
		sex.getSex();
		
		for(int x = 0; x < str1.length(); x++){
			m.eat();
			w.eat();
		}
		for(int x = 0; x < str1.length(); x++){
			m.sleep();
			w.sleep();
		}
	}

}

		