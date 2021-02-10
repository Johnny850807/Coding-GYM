package presenters;

import model.Answer;
import model.Question;
import respostories.entities.Vocabulary;

import java.util.List;

public interface EnglishLearningPresenter {

    void addViewListener(EnglishLearningView view);

    List<Vocabulary> queryAll();

//    void mange(String featureInput, String word);

    void addVocabulary(String word);

    void deleteVocabulary(String word);

    void review();

    interface EnglishLearningView {

        void onAddVocabularySuccessfully(Vocabulary vocabulary);

        void onDeleteVocabularySuccessfully();

        void onExamNoQuestionExist();

        Answer onNextQuestion(Question question);

        void onError(String regex, Exception e);

        void onAnswerCorrect();

        void onAnswerWrong(int lastAnswerTimes);

        void onExamFinished();

        void onExamFailed(String answer);
    }

}
