import java.util.*;
public class Main {
	static Subject mySubject;
	static Scores myScores;
	static Scanner scanner = new Scanner(System.in);
	public static void main(String[] args){
		int which;
		int score;
		while(true){
			which = InputSubject();
		}
	}
	public static void InputScores(){
		
	}
	public static int InputSubject(){
		boolean check = false;
		int which = 0;
		System.out.println("選擇計算總成績科目: (1)國文 (2)英文 (3)數學 : ");
		while (!check){
			which = scanner.nextInt();
			switch(which){
			case 1 :
				check = true;
				myScores = new Scores();
				mySubject = new Subject(new ChineseStrategy(),myScores);
				break;
			case 2 :
				check = true;
				myScores = new Scores();
				mySubject = new Subject(new EnglishStrategy(),myScores);
				break;
			case 3 :
				check = true;
				myScores = new Scores();
				mySubject = new Subject(new MathStrategy(),myScores);
				break;
			default :
				System.out.println("請輸入正確");
			}
		}
		return which;
			
		
	}
	
}
