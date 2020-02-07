package subject;

public class Chinese extends Subject {

    public Chinese(String subjectName) {
        super(subjectName);
    }

    @Override
    public int statistics(float attendance, float homeworkGrade,
                            float midTermResults, float finalGrade) {
        float beginningGrade;
        attendance = oneOfSubjectStatistics(attendance, 30);
        homeworkGrade = oneOfSubjectStatistics(homeworkGrade, 70);
        beginningGrade = oneOfSubjectStatistics((attendance + homeworkGrade), 40);
        midTermResults = oneOfSubjectStatistics(midTermResults, 20);
        finalGrade = oneOfSubjectStatistics(finalGrade, 40);
        return (int) (beginningGrade + midTermResults + finalGrade);
    }
}
