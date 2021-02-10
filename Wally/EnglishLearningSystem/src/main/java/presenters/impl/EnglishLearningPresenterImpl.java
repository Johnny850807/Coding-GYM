package presenters.impl;

import exceptions.*;
import model.Answer;
import model.Exam;
import model.Question;
import presenters.EnglishLearningPresenter;
import respostories.EnglishLearningRepository;
import respostories.entities.Vocabulary;
import respostories.entities.Vocabulary.Definition;
import respostories.entities.Vocabulary.PartOfSpeech;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import static config.Constants.*;

/**
 * @author - wally55077@gmail.com
 */
public class EnglishLearningPresenterImpl implements EnglishLearningPresenter {

    private final EnglishLearningRepository learningRepository;
    private EnglishLearningView viewListener;

    public EnglishLearningPresenterImpl(EnglishLearningRepository learningRepository) {
        this.learningRepository = learningRepository;
    }

    @Override
    public void addViewListener(EnglishLearningView view) {
        viewListener = view;
    }

    @Override
    public List<Vocabulary> queryAll() {
        return learningRepository.queryAll();
    }

    @Override
    public void addVocabulary(String word) {
        try {
            Vocabulary vocabulary = learningRepository.insert(word);
            viewListener.onAddVocabularySuccessfully(vocabulary);
        } catch (WordAlreadyExistException e) {
            viewListener.onError(VOCABULARY_ALREADY_EXIST, e);
        } catch (WordNotFoundException e) {
            viewListener.onError(VOCABULARY_NOT_FOUND, e);
        } catch (AddWordFailedException e) {
            viewListener.onError(ADD_VOCABULARY_ERROR, e);
        }
    }

    @Override
    public void deleteVocabulary(String word) {
        try {
            learningRepository.delete(word);
            viewListener.onDeleteVocabularySuccessfully();
        } catch (WordAlreadyExistException e) {
            viewListener.onError(VOCABULARY_ALREADY_EXIST, e);
        } catch (WordNotFoundException e) {
            viewListener.onError(VOCABULARY_NOT_FOUND, e);
        } catch (DeleteWordFailedException e) {
            viewListener.onError(DELETE_VOCABULARY_ERROR, e);
        }
    }

    @Override
    public void review() {
        Exam exam = new Exam();
        try {
            exam.createExam(learningRepository.queryAll());
            startExam(exam);
        } catch (ExamNoQuestionExistException e) {
            viewListener.onExamNoQuestionExist();
        } catch (QuestionFailedException e) {
            viewListener.onExamFailed(e.getMessage());
        } finally {
            updateExamResult(exam);
        }
    }

    private void startExam(Exam exam) {
        for (Question question : exam) {
            while (!question.isQuestionOver()) {
                Answer answer = viewListener.onNextQuestion(question);
                answerQuestion(answer, question);
            }
        }
        viewListener.onExamFinished();
    }

    private void answerQuestion(Answer answer, Question question) {
        if (question.commitAnswer(answer.getWord())) {
            viewListener.onAnswerCorrect();
        } else {
            viewListener.onAnswerWrong(question.getLastAnswerTimes());
        }
    }

    private void updateExamResult(Exam exam) {
        Map<String, Vocabulary> vocabularies = new HashMap<>();
        for (Question question : exam) {
            convertQuestionFromVocabulary(vocabularies, question);
        }
        learningRepository.update(vocabularies.values().toArray(new Vocabulary[0]));
    }

    private void convertQuestionFromVocabulary(Map<String, Vocabulary> vocabularies,
                                               Question question) {
        Vocabulary vocabulary = vocabularies.computeIfAbsent(question.getOriginWord(), Vocabulary::new);
        Map<PartOfSpeech, List<Definition>> allDefinitions = vocabulary.getDefinitions();
        List<Definition> partOfDefinitions = allDefinitions.computeIfAbsent(question.getPartOfSpeech(), partOfSpeech -> new LinkedList<>());
        partOfDefinitions.add(new Definition(question.getDefinition(), question.getUpdateDate()));
    }

}
