package �ǥ�;

/*import java.util.Arrays;*/
import java.util.Scanner;

public class StudentSystem {

	static Scanner input = new Scanner(System.in);
	public static void main(String[] args) {
		
		System.out.println("�п�J�ǥͼƶq: ");
		Information[] amount = new Information[input.nextInt()]; 
		
		int i;
		int a, b;
		
		for (i = 0; i < amount.length; i++) {
			amount[i] = new Information(input.nextDouble(), input.nextDouble(), input.nextInt(), input.next());
		}
		
		//Arrays.sort(); �����D�n����omethod�Φb�o
		for (a = amount.length-1; a >= 0; a--) {
			for (b = 0; b < a; b++) {
				if (amount[b].grades > amount[a].grades) {
					Information tmp = amount[a];
					amount[a] = amount[b];
					amount[b] = tmp;
				} 
			}
		}
		
		for (i = 0; i < amount.length; i++) {
			System.out.println(amount[i]);
		}
	}
}
