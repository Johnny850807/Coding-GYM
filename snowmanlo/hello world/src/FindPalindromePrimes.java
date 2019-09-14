public class FindPalindromePrimes {
    public static boolean isPalidromeAndPrime(int num) {
        if (isPrime(num))
            return isPalindrome(num);
        return false;
    }

    public static boolean isPrime(int num) {
        return findDivisor(num) == 2 ;
    }

    public static boolean isPalindrome(int num) {
        return num == reverseNum(num);
    }

    public static int findDivisor(int num) {
        int divisor = 0;
        for (int i = num; i > 0; i--) {
            if (num % i == 0)
                divisor++;
        }
        return divisor;
    }

    public static int reverseNum(int num) {
        int reNum = 0;
        while (num > 0) {
            int remainder = num % 10;
            num = num / 10;
            reNum = reNum * 10 + remainder;
        }
        return reNum;
    }

    public static void main(String[] args) {
       int num = 0;
       int count = 0;
       int row = 0;
       while (count < 100) {
           num++;
           if (isPalidromeAndPrime(num)) {
               row++;
               count++;
                if (row % 10 == 0)
                    System.out.println(num);
                else {
                    System.out.print(num + " ");
                }
           }
       }
    }
}
