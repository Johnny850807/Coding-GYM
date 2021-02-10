package utils.crawkler;

import exceptions.WordNotFoundException;
import respostories.entities.Vocabulary;

/**
 * @author i19
 */
public interface Crawler {
    /**
     * 爬Vocabulary.com的單字
     *
     * @param wordSpelling
     * @return
     * @throws WordNotFoundException
     */
    Vocabulary crawlVocabulary(String wordSpelling) throws WordNotFoundException;
}
