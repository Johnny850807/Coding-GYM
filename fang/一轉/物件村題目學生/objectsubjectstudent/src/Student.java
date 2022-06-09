public class Student {
    private int height;
    private int weight;
    private int score;
    private String studentId;

    public Student(int height, int weight, int score, String studentId) {
        this.height = height;
        this.weight = weight;
        this.score = score;
        this.studentId = studentId;
    }

    public int getScore() {
        return score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "height=" + height +
                ", weight=" + weight +
                ", score=" + score +
                ", studentId='" + studentId + '\'' +
                '}';
    }
}
