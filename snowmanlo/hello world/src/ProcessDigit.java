import java.util.Scanner;

public class ProcessDigit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("輸入100~999之間的數字");
        int num = scanner.nextInt();
        int hDigit = num / 100;
        int tDigit = (num / 10) % 10;
        int uDigit = num % 10;
        int sum = hDigit + tDigit + uDigit;
        int product = hDigit * tDigit * uDigit;
        int defference = hDigit - tDigit - uDigit;
        System.out.println(sum + "\n" + product + "\n" + defference);
    }
}
