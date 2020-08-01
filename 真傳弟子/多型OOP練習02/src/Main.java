import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Student[] stu = new Student[sc.nextInt()];

        for(int i = 0;i<stu.length;i++){
            stu[i] = new Student(sc.nextInt(),sc.nextInt(),sc.nextInt(),sc.nextLine());
        }

        for (int i=0;i<stu.length-1;i++){
            for (int j=i+1;j<stu.length;j++){
                if(stu[i].getGrades()>stu[j].getGrades()){

                    Student temp = stu[j];
                    stu[j] = stu[i];
                    stu[i] = temp;
                }
            }
        }

        for(Student a :stu){
            System.out.println(a);
        }
    }
}
