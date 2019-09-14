import java.text.SimpleDateFormat;
import java.util.*;

public class VocabularyExam {

    private VocabularyList englishVocabularyList;
    private HashMap<String, LinkedList<Definition>> examinationResult = new HashMap<>();

    public VocabularyExam(VocabularyList englishVocabularyList) {
        this.englishVocabularyList = englishVocabularyList;
    }

    public void startEnglishExam() {
        System.out.println("複習開始!");
        HashMap<String, LinkedList<Definition>> examinationRange = englishVocabularyList.getRecord();
        LinkedList<String> answerDateList = englishVocabularyList.getAnswerDateList();
        LinkedList<String> resultDateList = new LinkedList<>();
        boolean isExamTime = true;
        int times = 0;
        resultDateList.add("無");

        for (String answerDate : answerDateList) {
            LinkedList<Definition> definitionLinkedList = examinationRange.get(answerDate);
            while (!definitionLinkedList.isEmpty()) {
                Random randomQuestion = new Random();
                Definition question = definitionLinkedList.get(randomQuestion.nextInt(definitionLinkedList.size()));
                definitionLinkedList.remove(question);

                if (isExamTime) {
                    for (int answerTimes = 2; answerTimes >= 0; answerTimes--) {

                        System.out.println(question.getExamQuestion() + ":" + question.getPartOfSpeech() + question.getDefinition());
                        System.out.println("請輸入答案:");
                        String userAnswer = EnglishLearningSystem.input.nextLine();

                        if (userAnswer.equals(question.getVocabulary())) {
                            System.out.println("答對");
                            resultDateList.add(question.getAnswerDate());
                            Date correctAnswerDate = new Date();
                            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
                            question.setCorrectAnswerDate(dateFormat.format(correctAnswerDate));
                            resultDateList.add(question.getAnswerDate());
                            answerTimes = -1;
                        }
                        if (answerTimes > 0) {
                            System.out.println("錯誤，剩下" + answerTimes + "次機會");
                        } else if (answerTimes == 0) {
                            System.out.println("失敗！請多複習！答案為" + question.getVocabulary() + "!");
                            isExamTime = false;
                        }
                    }
                }

                if (examinationResult.containsKey(question.getAnswerDate())) {
                    examinationResult.get(question.getAnswerDate()).add(question);
                    times++;
                } else {
                    LinkedList<Definition> examinationResultList = new LinkedList<>();
                    examinationResultList.add(question);
                    examinationResult.put(question.getAnswerDate(), examinationResultList);
                    times++;
                }
            }

            if (examinationResult.containsKey(answerDate)) {
                if (examinationResult.get(answerDate).isEmpty()) {
                    examinationResult.remove(answerDate);
                }
            }
        }
        System.out.println(times);
        answerDateList.clear();
        examinationRange.clear();
        answerDateList.addAll(resultDateList);
        examinationRange.putAll(examinationResult);
        System.out.println("考試結束");
    }
}
