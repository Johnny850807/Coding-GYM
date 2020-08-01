public class English implements Subjects {

    private String name;

    public English() {
        this.name = "英文";
    }

    @Override
    public int count(int attendGrade, int wordGrade, int midExamGrade, int finalExamGrade) {
        return (int) (0.4 * (attendGrade * 0.4 + wordGrade * 0.6) + (midExamGrade + finalExamGrade) * 0.3);
    }

    @Override
    public String getName() {
        return name;
    }
}
