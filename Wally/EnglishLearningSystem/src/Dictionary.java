import java.util.List;
import java.util.Map;

import model.words.*;

public class Dictionary {

    private Crawler crawler = new CrawlerVocabularycom();

    public Dictionary() {
    }

    private Word searchVocabulary(String vocabulary) {
        String str = vocabulary;
        try {
            Word wordStr = crawler.crawlWord(str);
            //爬蟲程式會開始從Vocabulary.com上抓取此單字的意思
            return wordStr;
        } catch (WordNotExistException e) {
            //若該單字在字典中不存在
            return null;
        }
    }

    public boolean containVocabulary(String vocabulary) {
        return searchVocabulary(vocabulary) != null;
    }

    public Vocabulary getVocabulary(String userInputVocabulary) {
        return (new Vocabulary(userInputVocabulary, getDefinitions(userInputVocabulary)));
    }

    public Map getDefinitions(String vocabulary) {
        Word word = searchVocabulary(vocabulary);
        Map<PartOfSpeech, List<String>> definitions = word.getDefinitions(); //此單字的詞性→定義之資料結構
        return definitions;
    }

    public void printVocabularyInfo(String vocabulary) {
        Map<PartOfSpeech, List<String>> mapDefinitions = getDefinitions(vocabulary);
        for (PartOfSpeech pos : mapDefinitions.keySet()) {
            String partOfSpeech = pos.toString();
            System.out.println("詞性：" + pos);
            System.out.println("意思：");
            List<String> definitionsOfPos = (List<String>) mapDefinitions.get(pos);
            for (int i = 0; i < definitionsOfPos.size(); i++) {
                String oneOfdefinitions = definitionsOfPos.get(i);
                System.out.println((i + 1) + " : " + oneOfdefinitions);
            }
        }
    }
}
