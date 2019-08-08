import java.util.Scanner;

public class FindPrimes {
    public static boolean isPrime(int num) {
        return getFactorCount(num) == 2;
    }

    public static int getFactorCount(int num) {
        int num1 = num;
        int factor = 0;

        while (num1 != 0) {
            if (num % num1 == 0)
                factor++;
            num1--;
        }
        return factor;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("輸入一個數字:");
            int num = scanner.nextInt();

            if (isPrime(num))
                System.out.println("他是質數");
            else
                System.out.println("他不是質數");
        }

    }
}
