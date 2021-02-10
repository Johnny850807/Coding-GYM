package views;

import model.Answer;
import model.Question;
import presenters.EnglishLearningPresenter;
import presenters.EnglishLearningPresenter.EnglishLearningView;
import respostories.entities.Vocabulary;
import respostories.entities.Vocabulary.Definition;
import respostories.entities.Vocabulary.PartOfSpeech;

import java.io.InputStream;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

import static config.Constants.*;
import static utils.printer.Printer.*;

/**
 * @author - wally55077@gmail.com
 */
public class EnglishLearningSystem implements EnglishLearningView {

    private final Scanner INPUT;
    private final EnglishLearningPresenter learningPresenter;

    public EnglishLearningSystem(InputStream inputStream,
                                 EnglishLearningPresenter learningPresenter) {
        INPUT = new Scanner(inputStream);
        this.learningPresenter = learningPresenter;
        this.learningPresenter.addViewListener(this);
    }

    public void start() {
        printlnSystemInfoMessage(OPENING);
        String mainFeatureInput;
        do {
            printlnSystemInfoMessage(FIRST_OPTION + BRACES +
                            SECOND_OPTION + BRACES + THIRD_OPTION + BRACES,
                    MANGE_FEATURE_NAME, REVIEW_FEATURE_NAME, LEAVE_FEATURE_NAME);
            printUserMessage();
            mainFeatureInput = INPUT.nextLine();
            executeMainFeature(mainFeatureInput);
        } while (!LEAVE.equalsIgnoreCase(mainFeatureInput));
    }

    private void executeMainFeature(String mainFeatureInput) {
        switch (mainFeatureInput) {
            case MANGE -> mange();
            case REVIEW -> review();
            case LEAVE -> printlnSystemInfoMessage(TAKE_A_BOW);
            default -> printlnSystemErrorMessage(INPUT_INVALID_ANSWER);
        }
    }

    public void mange() {
        String subFeatureInput;
        do {
            printVocabularies();
            printlnSystemInfoMessage(FIRST_OPTION + BRACES +
                            SECOND_OPTION + BRACES +
                            THIRD_OPTION + BRACES,
                    ADD_VOCABULARY_FEATURE_NAME,
                    DELETE_VOCABULARY_FEATURE_NAME,
                    BACK_LAST_PAGE_FEATURE_NAME);
            printUserMessage();
            subFeatureInput = INPUT.nextLine();
            executeSubFeature(subFeatureInput);
        } while (!BACK_LAST_PAGE.equalsIgnoreCase(subFeatureInput));
    }

    private void printVocabularies() {
        String message = learningPresenter.queryAll().stream()
                .map(Vocabulary::getWord)
                .collect(Collectors.joining(COMMA + SPACE));
        if (!message.isEmpty()) {
            printlnSystemInfoMessage(YOUR_VOCABULARY);
            printlnSystemInfoMessage(message);
        }
    }

    private void executeSubFeature(String subFeatureInput) {
        switch (subFeatureInput) {
            case ADD_VOCABULARY:
                addVocabulary();
                break;
            case DELETE_VOCABULARY:
                deleteVocabulary();
                break;
            case BACK_LAST_PAGE:
//                printlnSystemInfoMessage(BACK_LAST_PAGE_FEATURE_NAME);
                break;
            default:
                printlnSystemErrorMessage(INPUT_INVALID_ANSWER);
        }
    }

    private void addVocabulary() {
        printlnSystemInfoMessage(INPUT_ADD_VOCABULARY);
        printUserMessage();
        String word = INPUT.nextLine();
        learningPresenter.addVocabulary(word);
    }

    private void deleteVocabulary() {
        printlnSystemInfoMessage(INPUT_DELETE_VOCABULARY);
        printUserMessage();
        String word = INPUT.nextLine();
        learningPresenter.deleteVocabulary(word);
    }

    private void review() {
        printlnSystemInfoMessage(START_EXAM + SPACE + EXCLAMATION);
        learningPresenter.review();
    }

    @Override
    public void onAddVocabularySuccessfully(Vocabulary vocabulary) {
        printlnSystemInfoMessage(VOCABULARY + SPACE + COLON + BRACES, vocabulary.getWord());
        Map<PartOfSpeech, List<Definition>> allDefinitions = vocabulary.getDefinitions();
        allDefinitions.forEach(this::printDefinition);
    }

    private void printDefinition(PartOfSpeech partOfSpeech, List<Definition> partOfDefinitions) {
        printlnSystemInfoMessage(PART_OF_SPEECH + SPACE + COLON + BRACES, partOfSpeech.toString());
        printlnSystemInfoMessage(DEFINITION + SPACE + COLON);
        for (int rowIndex = 1; rowIndex <= partOfDefinitions.size(); rowIndex++) {
            Definition definition = partOfDefinitions.get(rowIndex - 1);
            printlnSystemInfoMessage(rowIndex + SPACE + COLON + BRACES, definition.getDefinition());
        }
        printlnSystemInfoMessage(FINISHED + SPACE + EXCLAMATION);
    }

    @Override
    public void onDeleteVocabularySuccessfully() {
        printlnSystemInfoMessage(FINISHED + SPACE + EXCLAMATION);
    }

    @Override
    public void onExamNoQuestionExist() {

    }

    @Override
    public Answer onNextQuestion(Question question) {
        String questionWord = question.getQuestionWord();
        String definition = question.getDefinition();
        String partOfSpeech = question.getPartOfSpeech().name();
        printlnSystemInfoMessage(questionWord + SPACE + COLON + SPACE
                + LEFT_PARENTHESES + partOfSpeech + RIGHT_PARENTHESES + SPACE + definition);
        printlnSystemInfoMessage(INPUT_QUESTION_ANSWER + SPACE + COLON);
        printUserMessage();
        String answer = INPUT.nextLine();
        return new Answer(answer);
    }

    @Override
    public void onError(String regex, Exception e) {
        printlnSystemErrorMessage(regex);
    }

    @Override
    public void onAnswerCorrect() {
        printlnSystemInfoMessage(ANSWER_CORRECT + SPACE + EXCLAMATION);
    }

    @Override
    public void onAnswerWrong(int answerTimes) {
        printlnSystemInfoMessage(INPUT_QUESTION_ANSWER_ERROR, String.valueOf(answerTimes));
    }

    @Override
    public void onExamFinished() {
        printlnSystemInfoMessage(EXAM_FINISHED);
    }

    @Override
    public void onExamFailed(String answer) {
        printlnSystemInfoMessage(EXAM_FAILED, answer);
    }
}
