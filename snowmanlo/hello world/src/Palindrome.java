import java.util.Scanner;

public class Palindrome {
    public static int reverseNum(int num) {
        int renum = 0;
        while (num > 0) {
            int remainder = num % 10;
            num = num / 10;
            renum = renum * 10 + remainder;
        }
        return renum;
    }

    public static boolean isPalindrome(int num) {
        return reverseNum(num) == num;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("輸入數字判斷是不是回文");
        int num = input.nextInt();
        System.out.println(isPalindrome(num));
    }
}
