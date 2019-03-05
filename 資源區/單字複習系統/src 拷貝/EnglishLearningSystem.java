import java.util.Scanner;

public class EnglishLearningSystem {
	
	static VocabularyList englishVocabularyList = new VocabularyList();
	static VocabularyExam englishVocabularyExam = new VocabularyExam();
//	static Dictionary englishDictionary = new Dictionary();
	static TestRecord englishTestRecord = new TestRecord();
	
	static Scanner scan = new Scanner (System.in);
	
	public static void main(String[] args) {
		
		System.out.println("您好，歡迎來到英文單字複習系統 v1.0");
		String userInput ;					
		do {
			System.out.println("(1)管理單字(2)進行複習(3)離開");
			userInput = scan.nextLine() ;
			switch (userInput) {
			case "1":
				manageVocabularys();
				break;
			case "2":
				reviewmanageVocabularys();
				break;
			case "3":
			System.out.println("使用結束，感謝您的使用");
				break;
			default:
			System.out.println("輸入錯誤，請重新輸入");
				break;
			}
		}while(!userInput.equals("3"));
		System.out.println("感謝你的使用!!!");
	}
	private static void manageVocabularys() {
		System.out.println("(1)新增單字(2)刪除單字(3)返回");
		String userInput = scan.nextLine();
			switch (userInput) {
			case "1":
				englishVocabularyList.addVocabulary();
				break;
			case "2":
				englishVocabularyList.removeVocabulary();
				break;
			case "3":
			System.out.println("返回");
				break;
			default:
			System.out.println("輸入錯誤，請重新輸入");
				break;
			}	
		}
	private static void reviewmanageVocabularys() {
		englishVocabularyExam.updateExaminationRange();
		if (englishVocabularyList.getWordList().isEmpty()) {
			System.out.println("請先添加單字");
		}
		else {
			
		}
	}	
}
