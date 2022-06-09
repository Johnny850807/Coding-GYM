import java.util.Scanner;

public class Main{
    public static Scanner in = new Scanner(System.in);
    public static void main(String[] args) {
        int inputInt = in.nextInt();
        Student[] students = new Student[inputInt];

        for (int i = 0; i < students.length; i++) {
            students[i] = new Student(in.nextInt(),in.nextInt(),in.nextInt()
                    ,in.nextLine());
        }

        Student studentTemp;
        for (int i = 0; i < students.length - 1; i++) {
            for (int j = i; j < students.length - 1; j++) {
                if(students[j].getScore() > students[j+1].getScore()){
                    studentTemp = students[i];
                    students[i] = students[j+1];
                    students[j+1] = studentTemp;
                }
            }
        }

        for (Student s:students) {
            System.out.println(s);
        }
    }
}
