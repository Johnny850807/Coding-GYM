import java.util.Scanner;

public class DecimalToBinary {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("輸入一個數字");
        int num = input.nextInt();
        int remainder = 0;
        String output = "";
        for (int i = 0; i < 4; i++) {
            for (int n = 0; n < 4; n++) {
                remainder = num % 2;
                num = num / 2;
                output = remainder + output;
            }
            output = " " + output;
        }
        System.out.println(output);
        }
    }
