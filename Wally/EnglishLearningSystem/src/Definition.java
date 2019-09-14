import java.sql.Date;

public class Definition {
    private String vocabulary;
    private String partOfSpeech;
    private String definition;
    private String answerDate = "無";
    private String examQuestion = "";

    public Definition(String vocabulary, String partOfSpeech, String definition) {
        this.vocabulary = vocabulary;
        this.partOfSpeech = "(" + partOfSpeech + ".)";
        this.definition = definition;
    }

    public void setCorrectAnswerDate(String correctAnswerDate) {
        this.answerDate = correctAnswerDate;
    }

    public String getAnswerDate() {
        return answerDate;
    }

    public String getVocabulary() {
        return vocabulary;
    }

    public String getPartOfSpeech() {
        return partOfSpeech;
    }

    public String getDefinition() {
        return definition;
    }

    public String getExamQuestion() {
        if (!examQuestion.contains("_")) {
            examQuestion += vocabulary.charAt(0);
            examQuestion = examQuestion.replace("null", "");
            for (int i = 1; i < vocabulary.length(); i++) {
                if (vocabulary.length() > 2 && i == (vocabulary.length() - 1)) {
                    examQuestion += vocabulary.charAt((vocabulary.length() - 1));
                } else {
                    examQuestion += "_";
                }
            }
        }
        return examQuestion;
    }

    public String toString() {
        return "單字" + vocabulary + "\n詞性" + partOfSpeech + "\n定義" + definition;
    }
}
