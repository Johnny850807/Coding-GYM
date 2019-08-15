import java.util.*;

import model.words.PartOfSpeech;

public class Vocabulary {

    private String vocabulary;
    private ArrayList<Definition> definitionArrayList = new ArrayList<>();

    public Vocabulary(String vocabulary, Map definitions) {
        this.vocabulary = vocabulary;
        setDefinitions(definitions);
    }

    private void setDefinitions(Map definitions) {
        Map<PartOfSpeech, List<String>> mapDefinitions = definitions;
        for (PartOfSpeech pos : mapDefinitions.keySet()) {
            String partOfSpeech = pos.toString();
            List<String> definitionsOfPos = (List<String>) mapDefinitions.get(pos);
            for (int i = 0; i < definitionsOfPos.size(); i++) {
                String oneOfdefinitions = definitionsOfPos.get(i);
                definitionArrayList.add(new Definition(vocabulary, partOfSpeech, oneOfdefinitions));
            }
        }
    }

    public ArrayList<Definition> getDefinitionArrayList() {
        return definitionArrayList;
    }

    public String toString() {
        return vocabulary;
    }
}
