import java.util.Scanner;

public class ProgramTest {

	public static void main(String[] args) {
	
		Scanner input = new Scanner(System.in);
		System.out.println("Input: ");
		String str1 = input.nextLine();
		Human[] human = new Human[100];

		int i,x;
		
		for(i = 0; i < str1.length(); i++){
			char s = str1.charAt(i);
			
			if (s == 'b'|| s =='B')
				human[i] = new Man();
			else if (s == 'g'|| s =='G')
				human[i] = new Woman();
		}
		/*
		final int MAN = 1;
		final int WOMAN = 2;
		
		if ( human.type == MAN )
			human.manEat();
		else
			human.womanEat();*/
		
		for(x = 0; x < str1.length(); x++){
			human[x].eat();
		}
		for(x = 0; x < str1.length(); x++){
			human[x].sleep();
		}
		
	}

}

		
