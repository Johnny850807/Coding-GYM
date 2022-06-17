import java.util.Scanner;

public class Main {
    public static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        int inputInt = in.nextInt();
        Student[] students = new Student[inputInt];

        for (int i = 0; i < students.length; i++) {
            int height = in.nextInt();
            int weight = in.nextInt();
            int score = in.nextInt();
            String studentId = in.nextLine();
            students[i] = new Student(height, weight, score, studentId);
        }

        Student studentTemp;
        Student student;
        Student nextStudent;
        for (int i = 0; i < students.length - 1; i++) {
            for (int j = i + 1; j < students.length; j++) {
                student = students[i];
                nextStudent = students[j];
                if (student.getScore() > nextStudent.getScore()) {
                    studentTemp = student;
                    students[i] = nextStudent;
                    students[j] = studentTemp;
                }
            }
        }

        for (Student s : students) {
            System.out.println(s);
        }
    }
}
