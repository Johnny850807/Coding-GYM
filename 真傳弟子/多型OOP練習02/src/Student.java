public class Student  {

    private int high;
    private int weight;
    private int grades;
    private String id;

    public Student(int high, int weight, int grades, String id) {
        this.high = high;
        this.weight = weight;
        this.grades = grades;
        this.id = id;
    }

    @Override
    public String toString() {
        return "Student{" +
                "high=" + high +
                ", weight=" + weight +
                ", grades=" + grades +
                ", id='" + id + '\'' +
                '}';
    }

    public int getHigh() {
        return high;
    }

    public void setHigh(int high) {
        this.high = high;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getGrades() {
        return grades;
    }

    public void setGrades(int grades) {
        this.grades = grades;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
