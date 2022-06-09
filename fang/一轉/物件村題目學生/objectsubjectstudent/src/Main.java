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
        for (int i = 0; i < students.length - 1; i++) {
            for (int j = i; j < students.length - 1; j++) {
                if (students[j].getScore() > students[j + 1].getScore()) {
                    studentTemp = students[i];
                    students[i] = students[j + 1];
                    students[j + 1] = studentTemp;
                }
            }
        }

        for (Student s : students) {
            System.out.println(s);
        }
    }
}
