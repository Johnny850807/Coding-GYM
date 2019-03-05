import java.util.LinkedList;
import java.util.Scanner;

import model.words.Word;

public class VocabularyList {
	
	private Dictionary englishDictionary = new Dictionary();
	private LinkedList<String> wordList = new LinkedList<String>();
	
	public VocabularyList() {
	}

	public void addVocabulary() {
		System.out.println("請輸入要新增的單字："); 
		try {
			String userInput = EnglishLearningSystem.scan.nextLine();
			englishDictionary.showVocabularyinfo(userInput);
			wordList.add(userInput);
			System.out.println("已成功加入");
		} catch (NullPointerException e) {
			System.out.println("失敗加入");
		}
	}

	public void removeVocabulary() {	
		System.out.println("請輸入要刪除的單字：");
		String userInput = EnglishLearningSystem.scan.nextLine();	
		if (wordList.contains(userInput)){
			wordList.remove(userInput);
			System.out.println("成功刪除");
		}else {
			System.out.println("找不到該單字");
		}
	}
	public LinkedList getWordList() {
		return wordList ;
	}
}
