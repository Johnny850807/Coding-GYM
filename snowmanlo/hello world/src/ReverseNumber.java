import java.util.Scanner;

public class ReverseNumber {
    public  static  String reverseNum(int num) {
        int remainder = num;
        int quotient = 0;
        String output = "";
        while (num > 0) {
            remainder = num % 10;
            quotient = num / 10;
            num = quotient;
            output = output + remainder;
        }
        return output;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("輸入一個數字");
        int num = input.nextInt();
        System.out.println(reverseNum(num));
    }
}
