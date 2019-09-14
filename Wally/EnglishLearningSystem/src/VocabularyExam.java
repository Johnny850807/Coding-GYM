import java.text.SimpleDateFormat;
import java.util.*;

public class VocabularyExam {

    private Map<String, LinkedList<Definition>> examinationResult = new HashMap<String, LinkedList<Definition>>();
    private TestRecord testRecord = new TestRecord();

    public VocabularyExam(VocabularyList englishVocabularyList) {
        updateExaminationRange(englishVocabularyList);
    }

    private void updateExaminationRange(VocabularyList englishVocabularyList) {
        if (englishVocabularyList.getListSizeChange()||!englishVocabularyList.getOldVocabularyList().isEmpty()) {
            LinkedList<Vocabulary> vocabularyList = englishVocabularyList.getNewVocabularyList();
            LinkedList<String> answerDateList = new LinkedList<String>();
            for (Vocabulary vovabulary : vocabularyList) {
                ArrayList<Definition> definitionArrayList = vovabulary.getDefinitionArrayList();
                for (Definition definition : definitionArrayList) {
                    if (!testRecord.getTestRocord().containsValue(definition)) {
                        answerDateList.add(definition.getAnswerDate());
                        testRecord.setTestRecord(definition.getAnswerDate(), definition);
                    }
                }
            }
            englishVocabularyList.resetListSizeChange();
        }
    }

    public void startEnglishExam() {
        System.out.println("複習開始!");
        Map<String, LinkedList<Definition>> examinationRange;
        LinkedList<String> answerDateList = testRecord.getAnswerDateList();
        LinkedList<String> resultDateList = new LinkedList<String>();
        examinationRange = testRecord.getTestRocord();
        boolean isExamTime = true;

        for (String answerDate : answerDateList) {
            LinkedList<Definition> definitionLinkedList = examinationRange.get(answerDate);
            while (!definitionLinkedList.isEmpty()) {
                Random randomQuestion = new Random();
                Definition question = definitionLinkedList.get(randomQuestion.nextInt(definitionLinkedList.size()));
                LinkedList<Definition> examinationResultList = new LinkedList<Definition>();
                if (isExamTime) {
                    if (!examinationRange.containsValue(question)) {
                        System.out.println(question.getExamQuestion() + ":" + question.getPartOfSpeech() + question.getDefinition());
                        System.out.println("請輸入答案:");
                        for (int answerTimes = 2; answerTimes >= 0; answerTimes--) {
                            String userAnswer = EnglishLearningSystem.input.nextLine();
                            definitionLinkedList.remove(question);
                            if (userAnswer.equals(question.getVocabulary())) {
                                System.out.println("答對");
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
                                // bug位待修
                            }
                        }
                    }
                }

                examinationResultList.add(question);
                if (examinationResult.containsKey(question.getAnswerDate())) {
                    examinationResult.get(question.getAnswerDate()).add(question);
                } else {

                    examinationResult.put(question.getAnswerDate(), examinationResultList);
                }
            }
            if (!examinationResult.containsKey(answerDate)) {
                answerDateList.remove(answerDate);
            }
        }

        //answerDateList.addAll(resultDateList);
        testRecord.saveRecordFile(answerDateList, examinationResult);
        System.out.println("考試結束");
    }
}
