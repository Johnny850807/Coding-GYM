import java.util.Scanner;

public class EnglishLearningSystem {


	public static void main(String[] args) {
		VocabularyList englishVocabularys = new VocabularyList();
		VocabularyExam englishExam = new VocabularyExam();
		Dictionary englishDictionary = new Dictionary();
		TestRecord englishTestRecord = new TestRecord();
		
		Scanner scan = new Scanner (System.in);
		String userInput = scan.nextLine() ;		
		
		System.out.println("您好，歡迎來到英文單字複習系統 v1.0");
		do {
			System.out.println("(1)管理單字(2)進行複習(3)離開");
			
			switch (userInput) {
			case "1":
				
				break;
			case "2":
				
				break;
			default:
				break;
			}
			
			
		}while(!userInput.equals("3"));
		System.out.println("感謝你的使用!!!");
	}
	
}
