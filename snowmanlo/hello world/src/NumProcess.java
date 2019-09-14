import java.util.Scanner;

public class NumProcess {
    public static int inputNum(int num1, int num2) {
        int i = num1;
        while (i <= num2) {
            for (int j = 0; j < 7 && i <= num2; j++) {
                System.out.printf("%5d", num1);
                num1++;
                i++;
            }
            System.out.println();
        }
        return 0;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("輸入開頭和結尾的數字");
        int num1 = scanner.nextInt();
        int num2 = scanner.nextInt();
        if (num1 < num2)
            inputNum(num1, num2);
        else
            System.out.println("沒有結果");
    }
}
