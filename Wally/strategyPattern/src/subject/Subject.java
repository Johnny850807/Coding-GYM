package subject;

public abstract class Subject implements SubjectStatistics {
    protected String subjectName;

    public Subject(String subjectName) {
        this.subjectName = subjectName;
    }

    protected int oneOfSubjectStatistics(float score, float scoreProportion) {
        return (int) (score * scoreProportion / 100);
    }

    public String getSubjectName() {
        return subjectName;
    }
}
