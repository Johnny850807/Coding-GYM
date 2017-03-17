import java.util.Scanner;

public class Scores {
	private int attend;
	private int homework;
	private int middleexam;
	private int finalexam; 
	Scanner scanner = new Scanner(System.in); 
	public Scores(){
		setInputAttend();
		setInputHomework();
		setInputMiddleExam();
		setInputFinalExam();
	}
	public void setInputAttend(){
		System.out.println("輸入出席成績:");
		attend = scanner.nextInt();
	}
	public int getAttend(){
		return attend;
	}
	public void setInputHomework(){
		System.out.println("輸入作業成績:");
		homework = scanner.nextInt();
	}
	public int getHomework(){
		return homework;
	}
	public void setInputMiddleExam(){
		System.out.println("輸入期中成績:");
		middleexam = scanner.nextInt();
	}
	public int getMiddleExam(){
		return middleexam;
	}
	public void setInputFinalExam(){
		System.out.println("輸入期末成績:");
		finalexam = scanner.nextInt();
	}
	public int getFinalExam(){
		return finalexam;
	}
}
