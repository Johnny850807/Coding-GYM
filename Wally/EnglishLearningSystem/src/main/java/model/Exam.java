package model;

import exceptions.ExamNoQuestionExistException;
import respostories.entities.Vocabulary;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static model.Question.toQuestions;

/**
 * @author - wally55077@gmail.com
 */
public class Exam implements Iterable<Question> {

    private List<Question> questions;

    public void createExam(Collection<Vocabulary> vocabularies) {
        if (vocabularies.isEmpty()) {
            throw new ExamNoQuestionExistException();
        }
        questions = shuffleAndSortByUpdateDate(vocabularies.stream()
                .flatMap(v -> toQuestions(v).stream()));
    }

    private List<Question> shuffleAndSortByUpdateDate(Stream<Question> questionStream) {
        var questions = questionStream.collect(Collectors.toList());
        Collections.shuffle(questions);
        questions.sort(Comparator.comparing(Question::getUpdateDate));
        return questions;
    }

    @Override
    public Iterator<Question> iterator() {
        return questions.iterator();
    }
}
