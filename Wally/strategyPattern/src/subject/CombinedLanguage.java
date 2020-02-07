package subject;

public class CombinedLanguage extends Subject {

    public CombinedLanguage(String subjectName) {
        super(subjectName);
    }

    @Override
    public int statistics(float attendance, float homeworkGrade,
                          float midTermResults, float finalGrade) {
        float beginningGrade;
        attendance = oneOfSubjectStatistics(attendance, 50);
        homeworkGrade = oneOfSubjectStatistics(homeworkGrade, 50);
        beginningGrade = oneOfSubjectStatistics((attendance + homeworkGrade), 0);
        midTermResults = oneOfSubjectStatistics(midTermResults, 0);
        finalGrade = oneOfSubjectStatistics(finalGrade, 100);
        return (int) (beginningGrade + midTermResults + finalGrade);
    }
}
