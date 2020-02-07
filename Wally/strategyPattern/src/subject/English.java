package subject;

public class English extends Subject {

    public English(String subjectName) {
        super(subjectName);
    }

    @Override
    public int statistics(float attendance, float homeworkGrade,
                            float midTermResults, float finalGrade) {
        float beginningGrade;
        attendance = oneOfSubjectStatistics(attendance, 40);
        homeworkGrade = oneOfSubjectStatistics(homeworkGrade, 60);
        beginningGrade = oneOfSubjectStatistics((attendance + homeworkGrade), 40);
        midTermResults = oneOfSubjectStatistics(midTermResults, 30);
        finalGrade = oneOfSubjectStatistics(finalGrade, 30);
        return (int) (beginningGrade + midTermResults + finalGrade);
    }
}
