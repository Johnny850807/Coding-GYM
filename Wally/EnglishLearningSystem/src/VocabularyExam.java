import java.util.LinkedList;

public class VocabularyExam {
	
	private LinkedList<String> examinationRange ;
	public VocabularyExam() {
	}
	public void updateExaminationRange() {
		examinationRange = EnglishLearningSystem.englishVocabularyList.getWordList();
	}
	
}
