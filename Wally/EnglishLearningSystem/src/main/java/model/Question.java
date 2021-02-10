package model;

import exceptions.QuestionFailedException;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import respostories.entities.Vocabulary;
import respostories.entities.Vocabulary.Definition;
import respostories.entities.Vocabulary.PartOfSpeech;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @author - wally55077@gmail.com
 */
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Question {

    private static final int ANSWER_TIMES = 3;
    private int lastAnswerTimes = ANSWER_TIMES;
    private String originWord;
    private String questionWord;
    private PartOfSpeech partOfSpeech;
    private String definition;
    private LocalDate updateDate;
    private boolean isAnswerCorrect = false;

    public static List<Question> toQuestions(Vocabulary vocabulary) {
        List<Question> questions = new ArrayList<>(vocabulary.getDefinitions().values().size());
        String word = vocabulary.getWord();
        Map<PartOfSpeech, List<Definition>> allDefinitions = vocabulary.getDefinitions();
        allDefinitions.forEach((partOfSpeech, partOfDefinitions) ->
                partOfDefinitions.forEach(definition -> questions.add(covertVocabularyToQuestion(word, partOfSpeech, definition))));
        return questions;
    }

    private static Question covertVocabularyToQuestion(String word,
                                                       PartOfSpeech partOfSpeech,
                                                       Definition definition) {
        return Question.builder()
                .lastAnswerTimes(ANSWER_TIMES)
                .originWord(word)
                .questionWord(transformQuestion(word))
                .partOfSpeech(partOfSpeech)
                .definition(definition.getDefinition())
                .updateDate(definition.getUpdateDate()).build();
    }

    private static String transformQuestion(String originWord) {
        char[] questionWord = originWord.toCharArray();
        Arrays.fill(questionWord, 1, questionWord.length - 1, '_');
        return new String(questionWord);
    }

    public boolean commitAnswer(String answer) {
        if (isAnswerCorrect = originWord.equalsIgnoreCase(answer)) {
            updateDate();
        } else {
            lastAnswerTimes--;
            validateExamWrongAnswerTimes();
        }
        return isAnswerCorrect;
    }

    private void validateExamWrongAnswerTimes() {
        if (lastAnswerTimes <= 0) {
            throw new QuestionFailedException(originWord);
        }
    }

    public boolean isQuestionOver() {
        return isAnswerCorrect || lastAnswerTimes <= 0;
    }

    public String getDefinition() {
        return definition;
    }

    public String getOriginWord() {
        return originWord;
    }

    public String getQuestionWord() {
        return questionWord;
    }

    public PartOfSpeech getPartOfSpeech() {
        return partOfSpeech;
    }

    public LocalDate getUpdateDate() {
        return updateDate;
    }

    private void updateDate() {
        this.updateDate = LocalDate.now();
    }

    public int getLastAnswerTimes() {
        return lastAnswerTimes;
    }
}
