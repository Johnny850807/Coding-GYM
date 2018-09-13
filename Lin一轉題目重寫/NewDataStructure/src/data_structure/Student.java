package data_structure;

public class Student {
    private int number;

    public Student(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "學生編號(" + number + ")";
    }
}
