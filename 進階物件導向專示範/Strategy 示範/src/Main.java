import java.util.Scanner;

public class Main {
	private static Scanner userInput = new Scanner(System.in);
	public static void main(String[] args) {
		/** TODO 需求:  
		 * 	國文   平時  ( 出席30% + 作業70% ) 40%, 期中 20% , 期末 40%
		 *  英文   平時  ( 出席40% + 作業60% ) 40%, 期中 30% , 期末 30%
		 *  組合語言   平時  ( 出席50% + 作業50% ) 0%, 期中 0% , 期末 100%
		 * **/
		
		while(true){
			printInterface();
			countSumGradeAndPrint(inputSubjectType());
		}

	}
	
	private static void printInterface(){
		System.out.println("選擇計算總成績科目: (1)國文 (2)英文 (3)組合語言 : ");
	}
	
	private static int inputSubjectType(){
		int input;
		do
		{
			input = userInput.nextInt();
			if (input < 1 || input > 3)
				System.out.println("輸入錯誤 !!");
		}while ( input < 1 || input > 3 );
		return input;
	}
	
	private static void countSumGradeAndPrint(int subjectType){
		switch(subjectType)
		{
		case 1:
			new ChineseSubjectFactory().createSubject().printSumGradeInfo();
			break;
		case 2:
			new EnglishSubjectFactory().createSubject().printSumGradeInfo();
			break;
		case 3:
			new AssemblerSubjectFactory().createSubject().printSumGradeInfo();
			break;
		}
	}
	

}
