package utils.crawkler.impl;


import exceptions.WordNotFoundException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import respostories.entities.Vocabulary;
import respostories.entities.Vocabulary.PartOfSpeech;
import utils.crawkler.Crawler;

import java.io.IOException;

/**
 * @author i19
 */
public class CrawlerVocabularyCom implements Crawler {

    @Override
    public Vocabulary crawlVocabulary(String wordSpelling) {

        String link = "https://www.vocabulary.com/dictionary/" + wordSpelling;

        try {

            Document doc = Jsoup.connect(link).get();
            Elements definitions = doc.select("div.word-definitions > ol > li >div.definition");

            Vocabulary vocabulary = new Vocabulary(wordSpelling);

            if (definitions.isEmpty()) {
                throw new WordNotFoundException(wordSpelling);
            }

            for (Element element : definitions) {
                String text = element.text();
                String[] e = text.split(" ", 2);
                String partOfSpeech = e[0];
                String sentence = e[1];
                vocabulary.addDefinition(PartOfSpeech.valueOf(partOfSpeech.toUpperCase()), sentence);
            }
            return vocabulary;
        } catch (IOException | WordNotFoundException e) {
            return null;
        }
    }
}


