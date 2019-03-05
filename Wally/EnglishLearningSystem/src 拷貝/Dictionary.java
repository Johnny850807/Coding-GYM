import java.util.List;
import java.util.Map;
import model.words.*;

public class Dictionary {

	public Dictionary() {
		
	}
	public Word searchVocabularys(String vocabulary) {
		Crawler crawler = new CrawlerVocabularycom();
		String wordStr = vocabulary;
		try {
			Word word = crawler.crawlWord(wordStr); //爬蟲程式會開始從Vocabulary.com上抓取此單字的意思
			return word ;
		} catch (WordNotExistException e) {
			//若該單字在字典中不存在
			System.out.println("找不到該單詞。");
		}
		return null;
	}
	public void showVocabularyinfo(String vocabulary) {
		Crawler crawler = new CrawlerVocabularycom();
		String wordStr = vocabulary;
		try {
			Word word = crawler.crawlWord(wordStr); //爬蟲程式會開始從Vocabulary.com上抓取此單字的意思
			Map<PartOfSpeech, List<String>> definitions = word.getDefinitions(); //此單字的詞性→定義之資料結構
			System.out.println("單字：" + word.getWord());
			for (PartOfSpeech pos : definitions.keySet()) //走訪此單字的所有詞性並印出不同詞性下的所有定義
			{
				System.out.println("詞性：" + pos);
				System.out.println("意思：");
				List<String> definitionsOfPos = definitions.get(pos);
				for (int i = 0; i < definitionsOfPos.size(); i ++)
					System.out.println((i+1) + " : " + definitionsOfPos.get(i));
			}
		} catch (WordNotExistException e) {
			//若該單字在字典中不存在
			System.out.println("找不到該單詞。");
		}
	}

}
