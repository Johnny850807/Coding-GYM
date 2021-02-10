package respostories.impl;

import config.Constants;
import config.VocabularyFileResourceProperty;
import exceptions.*;
import lombok.SneakyThrows;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;
import respostories.EnglishLearningRepository;
import respostories.entities.Vocabulary;
import respostories.entities.Vocabulary.Definition;
import respostories.entities.Vocabulary.PartOfSpeech;
import utils.crawkler.Crawler;
import utils.crawkler.impl.CrawlerVocabularyCom;

import java.io.*;
import java.util.*;

import static config.Constants.*;

/**
 * @author - wally55077@gmail.com
 */
public class EnglishLearningFileRepository implements EnglishLearningRepository {

    private File fileResource;
    private final Map<String, Vocabulary> vocabularyCache = new LinkedHashMap<>();
    private final Crawler crawler = new CrawlerVocabularyCom();

    public EnglishLearningFileRepository() {
        configVocabularyResourceFromFile();
        configVocabularyCacheFromFile();
    }

    private void configVocabularyResourceFromFile() {
        Yaml yaml = new Yaml(new Constructor(VocabularyFileResourceProperty.class));
        InputStream inputStream = this.getClass().getClassLoader()
                .getResourceAsStream(Constants.CONFIG_FILE_PATH);
        VocabularyFileResourceProperty property = yaml.load(inputStream);
        String resourcePath = property.getVocabularyResourcePath();
        createFileIfNotExist(resourcePath);
    }

    @SneakyThrows(IOException.class)
    private void createFileIfNotExist(String resourcePath) {
        fileResource = new File(resourcePath);
        assert fileResource.exists() || fileResource.createNewFile();
    }

    /**
     * Word,PartOfSpeech,Definition,UpdateTime
     */
    private void configVocabularyCacheFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileResource))) {
            reader.lines().forEach(this::configVocabulary);
        } catch (IOException err) {
            err.printStackTrace();
        }
    }

    private void configVocabulary(String vocabularyData) {
        String[] vocabularyDataArray = vocabularyData.split(SLASH_SPLIT, 4);
        String word = vocabularyDataArray[0];
        if (!vocabularyCache.containsKey(word)) {
            vocabularyCache.put(word, new Vocabulary(word));
        }
        Vocabulary vocabulary = vocabularyCache.get(word);
        PartOfSpeech partOfSpeech = PartOfSpeech.valueOf(vocabularyDataArray[1]);
        Map<PartOfSpeech, List<Definition>> allDefinitions = vocabulary.getDefinitions();
        if (!allDefinitions.containsKey(partOfSpeech)) {
            allDefinitions.put(partOfSpeech, new LinkedList<>());
        }
        List<Definition> partDefinitions = allDefinitions.get(partOfSpeech);
        String definition = vocabularyDataArray[2], updateTime = vocabularyDataArray[3];
        partDefinitions.add(new Definition(definition, updateTime));
    }

    @Override
    public boolean exist(String wordSpelling) {
        return vocabularyCache.containsKey(wordSpelling);
    }

    @Override
    public List<Vocabulary> queryAll() {
        return new LinkedList<>(vocabularyCache.values());
    }

    @Override
    public Vocabulary insert(String wordSpelling) {
        if (!exist(wordSpelling)) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileResource))) {
                Vocabulary vocabulary = crawler.crawlVocabulary(wordSpelling);
                vocabularyCache.put(wordSpelling, vocabulary);
                writer.write(transformVocabularyCacheToString(vocabularyCache));
                writer.flush();
                return vocabulary;
            } catch (IOException err) {
                throw new AddWordFailedException(wordSpelling);
            }
        }
        throw new WordAlreadyExistException(wordSpelling);
    }

    @Override
    public void delete(String wordSpelling) {
        if (exist(wordSpelling)) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileResource))) {
                vocabularyCache.remove(wordSpelling);
                writer.write(transformVocabularyCacheToString(vocabularyCache));
                writer.flush();
            } catch (IOException err) {
                throw new DeleteWordFailedException(wordSpelling);
            }
        } else {
            throw new WordNotFoundException(wordSpelling);
        }
    }

    @Override
    public void update(Vocabulary... vocabularies) {
        String wordSpelling = EMPTY;
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileResource))) {
            for (Vocabulary vocabulary : vocabularies) {
                wordSpelling = vocabulary.getWord();
                if (exist(wordSpelling)) {
                    vocabularyCache.replace(wordSpelling, vocabulary);
                    writer.write(transformVocabularyCacheToString(vocabularyCache));
                    writer.flush();
                } else {
                    throw new WordNotFoundException(wordSpelling);
                }
            }
        } catch (IOException err) {
            throw new UpdateWordFailedException(wordSpelling);
        }
    }

    private String transformVocabularyCacheToString(Map<String, Vocabulary> vocabularyCache) {
        StringBuilder vocabularyData = new StringBuilder();
        vocabularyCache.values().forEach(vocabulary ->
                vocabularyData.append(transformVocabularyToString(vocabulary)));
        return vocabularyData.toString().trim();
    }

    private String transformVocabularyToString(Vocabulary vocabulary) {
        if (Optional.ofNullable(vocabulary).isPresent()) {
            StringBuilder vocabularyData = new StringBuilder();
            String word = vocabulary.getWord();
            vocabulary.getDefinitions()
                    .forEach((partOfSpeech, definitions) ->
                            definitions.forEach(definition ->
                                    vocabularyData.append(word).append(SLASH)
                                            .append(partOfSpeech).append(SLASH)
                                            .append(definition.getDefinition()).append(SLASH)
                                            .append(definition.getStringUpdateTime()).append(NEXT_LINE)));
            return vocabularyData.toString();
        }
        return EMPTY;
    }

}
