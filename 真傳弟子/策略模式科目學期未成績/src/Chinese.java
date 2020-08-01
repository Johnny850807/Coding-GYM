public class Chinese implements Subjects {

    private String name;

    public Chinese() {
        this.name = "國文";
    }

    @Override
    public int count(int attendGrade, int wordGrade, int midExamGrade, int finalExamGrade) {
        return (int) (0.4 * (attendGrade * 0.3 + wordGrade * 0.7) + midExamGrade * 0.2 + finalExamGrade * 0.4);
    }

    @Override
    public String getName() {
        return name;
    }

}
