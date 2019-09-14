import com.sun.source.tree.NewArrayTree;

import java.sql.SQLOutput;
import java.util.Scanner;

public class GreatestCommonDivisor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("輸入兩個數字");
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        int d;
        if (y > x) {
            d = x;
            x = y;
            y = d;
        }
        int y1 = y;
        while (x % y1 != 0) {
            y1--;
        }
        while (y % y1 != 0) {
            y1--;
        }
        System.out.println("最大公因數" + y1);
    }
}
