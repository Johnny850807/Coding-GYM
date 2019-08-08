import java.util.Scanner;

public class FindScore {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("輸入人數");
        int number = input.nextInt();
        int count = 1;
        int first = 0;
        int second = 0;
        while (count <= number) {
            System.out.println("請輸入成績0~100分");
            int score = input.nextInt();
            if ( score > first) {
                second = first;
                first = score;
            }
            else if (score > second) {
                second = score;
            }
            count++;
        }
        if (number == 1)
            second = first;
        System.out.println("最高分:" + first);
        System.out.println("第二高分:" + second);

    }
}
