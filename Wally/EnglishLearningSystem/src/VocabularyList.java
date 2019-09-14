
import java.io.*;
import java.util.*;

public class VocabularyList {

    private Dictionary englishDictionary = new Dictionary();
    private LinkedList<String> answerDateList = new LinkedList<>();
    private HashMap<String, ArrayList<Definition>> vocabularyMap = new HashMap<>();
    private HashMap<String, LinkedList<Definition>> record = new HashMap<>();
    private String vocabularyListPath = ".//vocabularyList.txt";
    private File vocabularyFile = new File(vocabularyListPath);

    public VocabularyList() {
        readFile();
    }

    public void addVocabulary(String userInputVocabulary) {
        if (vocabularyMap.containsKey(userInputVocabulary)) {
            System.out.println("已存在該單字");
        } else {
            if (englishDictionary.containVocabulary(userInputVocabulary)) {
                englishDictionary.printVocabularyInfo(userInputVocabulary);
                Vocabulary vocabulary = englishDictionary.getVocabulary(userInputVocabulary);
                vocabularyMap.put(userInputVocabulary, vocabulary.getDefinitionArrayList());
                System.out.println("已成功加入");
            } else {
                System.out.println("加入失敗");
            }
        }
    }

    public void removeVocabulary(String userInputVocabulary) {
        ArrayList<Definition> definitionArray;
        if (vocabularyMap.containsKey(userInputVocabulary)) {
            definitionArray = vocabularyMap.get(userInputVocabulary);
            vocabularyMap.remove(userInputVocabulary);
            for (Definition definition : definitionArray) {
                String answerDate = definition.getAnswerDate();
                if (record.containsKey(answerDate)) {
                    record.get(answerDate).remove(definition);
                    System.out.println("成功刪除");
                }
            }
        } else {
            System.out.println("找不到該單字");
        }
    }

    private void readFile() {
        try {
            FileReader vocabularyFileReader = new FileReader(vocabularyFile);
            BufferedReader vocabularyBufferedReader = new BufferedReader(vocabularyFileReader);
            while (vocabularyBufferedReader.ready()) {
                String recordVocabulary = "";
                String recordPartOfSpeech = "";
                String recordDefinition = "";
                String recordDate = "";
                for (int row = 1; row <= 5; row++) {
                    String recordLine = vocabularyBufferedReader.readLine();
                    if (recordLine != null) {
                        recordLine = recordLine.replace("\n", "");
                        if (recordLine.contains("單字: ")) {
                            recordVocabulary = recordLine.replace("單字: ", "");
                        } else if (recordLine.contains("詞性: ")) {
                            recordPartOfSpeech = recordLine.replace("詞性: ", "");
                        } else if (recordLine.contains("意思: ")) {
                            recordDefinition = recordLine.replace("意思: ", "");
                        } else if (recordLine.contains("時間: ")) {
                            recordDate = recordLine.replace("時間: ", "");
                        }
                    }
                }
                Definition definition = new Definition(recordVocabulary, recordPartOfSpeech, recordDefinition);
                if (vocabularyMap.containsKey(recordVocabulary)) {
                    vocabularyMap.get(recordVocabulary).add(definition);
                } else {
                    ArrayList<Definition> definitionArray = new ArrayList<>();
                    definitionArray.add(definition);
                    vocabularyMap.put(recordVocabulary, definitionArray);
                }
                checkDate(recordDate, definition);
            }
            vocabularyFileReader.close();
            vocabularyBufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void saveFile() {
        setRecord();
        try {
            FileWriter vocabularyFileWriter = new FileWriter(vocabularyFile);
            BufferedWriter vocabularyBufferedWriter = new BufferedWriter(vocabularyFileWriter);
            if (!vocabularyMap.isEmpty()) {
                StringBuilder saveVocabulary = new StringBuilder();
                for (String answerDate : answerDateList) {
                    if (record.containsKey(answerDate)) {
                        LinkedList<Definition> definitionList = record.get(answerDate);
                        for (Definition definition : definitionList) {
                            saveVocabulary.append("單字: " + definition.getVocabulary() + "\n");
                            saveVocabulary.append("詞性: " + definition.getPartOfSpeech() + "\n");
                            saveVocabulary.append("意思: " + definition.getDefinition() + "\n");
                            saveVocabulary.append("時間: " + definition.getAnswerDate() + "\n\n");
                        }
                    }
                }
                vocabularyBufferedWriter.write(saveVocabulary.toString());
            }
            vocabularyBufferedWriter.flush();
            vocabularyFileWriter.close();
            vocabularyBufferedWriter.close();
        } catch (IOException e) {

        }
    }

    private void setRecord() {
        for (String vocabulary : vocabularyMap.keySet()) {
            ArrayList<Definition> definitionArray = vocabularyMap.get(vocabulary);
            for (Definition definition : definitionArray) {
                String answerDate = definition.getAnswerDate();
                checkDate(answerDate, definition);
            }
        }
    }

    private void checkDate(String answerDate, Definition definition) {
        if (!record.containsKey(answerDate)) {
            record.put(answerDate, new LinkedList<>());
        }
        LinkedList<Definition> definitionLinkedList = record.get(answerDate);
     //   String vocabulary = definition.getVocabulary();
        if (!definitionLinkedList.contains(definition)) {
            definitionLinkedList.add(definition);
        }
        if (!answerDateList.contains(answerDate)) {
            answerDateList.add(answerDate);
        }
    }

    public HashMap<String, ArrayList<Definition>> getVocabularyMap() {
        return vocabularyMap;
    }

    public LinkedList getAnswerDateList() {
        return answerDateList;
    }

    public HashMap<String, LinkedList<Definition>> getRecord() {
        return record;
    }
}
