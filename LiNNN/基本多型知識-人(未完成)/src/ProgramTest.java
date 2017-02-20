import java.util.Scanner;

public class ProgramTest {

	public static void main(String[] args) {
	
		Scanner input = new Scanner(System.in);
		Human[] human = new Human[100];
		human[1] = new Man();  // 回傳Man類別	
		human[2] = new Woman();
		/*
		final int MAN = 1;
		final int WOMAN = 2;
		
		if ( human.type == MAN )
			human.manEat();
		else
			human.womanEat();*/
		
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

		
