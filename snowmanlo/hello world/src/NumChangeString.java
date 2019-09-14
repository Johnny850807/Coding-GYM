import java.util.Scanner;

public class NumChangeString {
    public static String getChangeUseChar(int num) {
        String snum = String.valueOf(num);
        String output = "";
        int count = snum.length() - 1;
        while (count >= 0) {
            char i = snum.charAt(count);
            output = i + " " + output;
            count--;
        }
        return output;
    }

    public static String getChange(int num) {
        int remainder = num;
        int quotient = 0;
        String output = "";
        while (num > 0) {
            remainder = num % 10;
            quotient = num / 10;
            num = quotient;
            output = remainder + " " + output;
        }
        return output;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("輸入一組數字");
        int num = input.nextInt();

        System.out.println(getChangeUseChar(num));
        System.out.println(getChange(num));
    }
}
