package respostories;

import respostories.entities.Vocabulary;

import java.util.List;

public interface EnglishLearningRepository {

    boolean exist(String wordSpelling);

    List<Vocabulary> queryAll();

    void delete(String wordSpelling);

    Vocabulary insert(String wordSpelling);

    void update(Vocabulary... vocabularies);

}
