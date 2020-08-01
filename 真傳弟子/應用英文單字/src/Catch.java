import model.words.*;

import java.util.List;
import java.util.Map;

public class Catch {

    private static final Crawler crawler = new CrawlerVocabularycom();

    public Catch() {

    }

    public static class catchInstance {
        static final Catch instance = new Catch();
    }

    public void searchWordPartOfSpeechAndMean(String inPutWord) throws WordNotExistException {
        Word word = crawler.crawlWord(inPutWord);
        Map<PartOfSpeech, List<String>> definitions = word.getDefinitions();
        System.out.println("單字：" + word.getWord());
        for (PartOfSpeech pos : definitions.keySet()) //走訪此單字的所有詞性並印出不同詞性下的所有定義
        {
            System.out.println("詞性：" + pos);
            System.out.println("意思：");
            List<String> definitionsOfPos = definitions.get(pos);
            for (int i = 0; i < definitionsOfPos.size(); i++)
                System.out.println((i + 1) + " : " + definitionsOfPos.get(i));
        }
}

    public void searchWordOfTest(String inPutWord) throws WordNotExistException {
        Word word = crawler.crawlWord(inPutWord);
        Map<PartOfSpeech, List<String>> definitions = word.getDefinitions();
        for (PartOfSpeech pos : definitions.keySet()) //走訪此單字的所有詞性並印出不同詞性下的所有定義
        {
            System.out.print("(" + pos + ".)");
            List<String> definitionsOfPos = definitions.get(pos);
                System.out.print(definitionsOfPos.get((int) (Math.random()*definitionsOfPos.size())));
                return;
        }

    }

    public static Catch getInstance(){
        return catchInstance.instance;
    }
}
