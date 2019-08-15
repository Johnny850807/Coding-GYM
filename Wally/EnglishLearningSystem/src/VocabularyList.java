
import java.io.*;
import java.util.LinkedList;

public class VocabularyList {

    private Dictionary englishDictionary = new Dictionary();
    private LinkedList<Vocabulary> oldVocabularyLinkedList = new LinkedList<Vocabulary>();
    private LinkedList<Vocabulary> newVocabularyLinkedList = new LinkedList<Vocabulary>();
    private String vocabularyListPath = ".//vocabularyList.txt";
    private File vocabularyFile = new File(vocabularyListPath);
    private boolean isListSizeChange = false;

    public VocabularyList() {
        readFile();
    }

    public void addVocabulary(String userInputVocabulary) {
        for (Vocabulary v : newVocabularyLinkedList) {
            newVocabularyLinkedList.remove(v);
        }
        if (contains(userInputVocabulary)) {
            System.out.println("已存在該單字");
        } else {
            if (englishDictionary.containVocabulary(userInputVocabulary)) {
                englishDictionary.printVocabularyInfo(userInputVocabulary);
                newVocabularyLinkedList.add(englishDictionary.getVocabulary(userInputVocabulary));
                isListSizeChange = true;
                System.out.println("已成功加入");
            } else {
                System.out.println("加入失敗");
            }
        }
        oldVocabularyLinkedList.addAll(newVocabularyLinkedList);
    }

    public void removeVocabulary(String userInputVocabulary) {

        if (!contains(userInputVocabulary)) {
            System.out.println("找不到該單字");
            return;
        }
        for (int vocabularyIndex = 0; vocabularyIndex < newVocabularyLinkedList.size(); vocabularyIndex++) {
            if ((newVocabularyLinkedList.get(vocabularyIndex).toString()).equals(userInputVocabulary)) {
                newVocabularyLinkedList.remove(newVocabularyLinkedList.get(vocabularyIndex));
                System.out.println("成功刪除");
            }
        }
    }
    public LinkedList getOldVocabularyList(){
        return oldVocabularyLinkedList;
    }

    public LinkedList getNewVocabularyList() {
        return newVocabularyLinkedList;
    }

    public boolean contains(String vocabulary) {
        for (Vocabulary v : oldVocabularyLinkedList) {
            if ((v.toString()).equals(vocabulary)) {
                return true;
            }
        }
        return false;
    }

    public boolean isEmpty() {
        return oldVocabularyLinkedList.isEmpty();
    }

    public void readFile() {
        String fileVocabulary = "";
        try {
            FileReader vocabularyFileReader = new FileReader(vocabularyFile);
            BufferedReader vocabularyBufferedReader = new BufferedReader(vocabularyFileReader);
            do {
                if (vocabularyBufferedReader.ready()) {
                    fileVocabulary += vocabularyBufferedReader.readLine() + "\n";
                }
            } while (vocabularyBufferedReader.ready());
            vocabularyFileReader.close();
            vocabularyBufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String[] vocabularyArray = fileVocabulary.split("\n");
        if (!fileVocabulary.isEmpty()) {
            for (String vocabulary : vocabularyArray) {
                oldVocabularyLinkedList.add(englishDictionary.getVocabulary(vocabulary));
            }
        }
    }

    public void saveFile() {
        isListSizeChange = false;
        String saveVocabulary = "";
        try {
            FileWriter vocabularyFileWriter = new FileWriter(vocabularyFile);
            BufferedWriter vocabularyBufferedWriter = new BufferedWriter(vocabularyFileWriter);

            for (int i = 0; i < oldVocabularyLinkedList.size(); i++) {
                String vocabulary = (oldVocabularyLinkedList.get(i)).toString();
                saveVocabulary += vocabulary + "\n";
            }
            vocabularyBufferedWriter.write(saveVocabulary);
            vocabularyBufferedWriter.flush();
            vocabularyFileWriter.close();
            vocabularyBufferedWriter.close();
        } catch (IOException e) {

        }
    }

    public boolean getListSizeChange() {
        return isListSizeChange;
    }

    public void resetListSizeChange() {
        isListSizeChange = false;
    }
}
