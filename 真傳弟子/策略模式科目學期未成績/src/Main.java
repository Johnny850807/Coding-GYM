import java.util.Scanner;

public class Main {
    private static Scanner input = new Scanner(System.in);
    private static Subjects[] subjects = new Subjects[]{new Chinese(), new English(), new AssemblyLanguage()};
    private static Subjects selectSubject;

    public static void main(String[] args) {
        start();
    }

    public static void start(){
        while(true) {
            selectSubject();
            inputGrade();
        }
    }

    public static void selectSubject() {
        int select;

        System.out.println("選擇計算總成績科目: (1)國文 (2)英文 (3)組合語言 :");
        do {
            select = input.nextInt();
        } while (select < 1 || select > 3);
        selectSubject = subjects[select - 1];
    }

    public static void inputGrade() {
        System.out.println("出席成績:");
        int attendGrade = detectInputGrade();
        System.out.println("作業成績:");
        int workGrade = detectInputGrade();
        System.out.println("期中成績:");
        int midExamGrade = detectInputGrade();
        System.out.println("期末成績:");
        int finalExamGrade = detectInputGrade();

        System.out.println(selectSubject.getName()+"--學期總成績 "+selectSubject.count(attendGrade,workGrade,midExamGrade,finalExamGrade));
    }

    public static int detectInputGrade(){
        int inputGrade;

        do{
            inputGrade = input.nextInt();

        }while(inputGrade < 0 || inputGrade >100);
        return inputGrade;
    }
}