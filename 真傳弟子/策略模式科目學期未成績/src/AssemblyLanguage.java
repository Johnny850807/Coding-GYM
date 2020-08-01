public class AssemblyLanguage implements Subjects {

    private String name;

    public AssemblyLanguage() {
        this.name = "組合語言";
    }

    @Override
    public int count(int attendGrade, int wordGrade, int midExamGrade, int finalExamGrade) {
        return finalExamGrade;
    }

    @Override
    public String getName() {
        return name;
    }
}
