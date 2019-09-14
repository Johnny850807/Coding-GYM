import java.io.*;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class TestRecord {

    private String testRecordPath = ".//testRecord.txt";
    private File testRecordFile = new File(testRecordPath);
    private Map<String, LinkedList<Definition>> testRocord = new HashMap<String, LinkedList<Definition>>();
    private LinkedList<String> answerDateList = new LinkedList<>();

    public TestRecord() {
        readTestRecordFile();
    }

    private void readTestRecordFile() {
        try {
            FileReader recordFileReader = new FileReader(testRecordFile);
            BufferedReader recordBufferedReader = new BufferedReader(recordFileReader);
            while (recordBufferedReader.ready()) {
                String recordVocabulary = null;
                String recordPartOfSpeech = null;
                String recordDefinition = null;
                String recordDate = null;

                for (int row = 1; row <= 4; row++) {
                    String recordLine = recordBufferedReader.readLine();
                    recordLine = recordLine.replace("null", "");
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
                Definition definition = new Definition(recordVocabulary, recordPartOfSpeech, recordDefinition);
                setTestRecord(recordDate, definition);
            }
            recordFileReader.close();
            recordBufferedReader.close();
        } catch (IOException e) {

        }
    }

    public void saveRecordFile(LinkedList<String> answerDateList, Map<String, LinkedList<Definition>> testResult) {
        if (testResult == null) {
            readTestRecordFile();
            testResult = testRocord;
        }
        try {
            FileWriter recordFileWriter = new FileWriter(testRecordFile);
            BufferedWriter recordBufferedWriter = new BufferedWriter(recordFileWriter);
            for (String answerDate : answerDateList) {
                LinkedList<Definition> definitionList = testResult.get(answerDate);
                for (Definition definition : definitionList) {
                    recordBufferedWriter.write("單字: " + definition.getVocabulary() + "\n");
                    recordBufferedWriter.write("詞性: " + definition.getPartOfSpeech() + "\n");
                    recordBufferedWriter.write("意思: " + definition.getDefinition() + "\n");
                    recordBufferedWriter.write("時間: " + definition.getAnswerDate() + "\n");
                }
            }
            recordBufferedWriter.write("");
            recordBufferedWriter.flush();
            recordFileWriter.close();
            recordBufferedWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setTestRecord(String recordDate, Definition definition) {
        LinkedList<Definition> definitionList;
        if (!testRocord.containsKey(recordDate)) {
            answerDateList.add(recordDate);
            definitionList = new LinkedList<Definition>();
            definitionList.add(definition);
            testRocord.put(recordDate, definitionList);
        } else {
            testRocord.get(recordDate).add(definition);
        }
    }

    public LinkedList<String> getAnswerDateList() {
        return answerDateList;
    }

    public Map<String, LinkedList<Definition>> getTestRocord() {
        return testRocord;
    }
}
