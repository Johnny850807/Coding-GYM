package 學生;

/*import java.util.Arrays;*/
import java.util.Scanner;

public class StudentSystem {

	static Scanner input = new Scanner(System.in);
	public static void main(String[] args) {
		
		System.out.println("請輸入學生數量: ");
		Information[] amount = new Information[input.nextInt()]; 
		
		int i;
		int a, b;
		
		for (i = 0; i < amount.length; i++) {
			amount[i] = new Information(input.nextDouble(), input.nextDouble(), input.nextInt(), input.next());
		}
		
		//Arrays.sort(); 不知道要怎麼把這method用在這
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
