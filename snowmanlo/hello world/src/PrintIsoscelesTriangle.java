import java.sql.SQLOutput;
import java.util.Scanner;

public class PrintIsoscelesTriangle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("輸入有幾層");
        int floor = scanner.nextInt();
        int starCount = floor * 2 - 1;
        int space;
        int star;
        for (int i = 1; i < floor; i++) {
            star = i * 2 - 1;
            space = (starCount - star) / 2;
            for (int j = 0; j < space; j++)
                System.out.print(" ");
            for (int j = 0; j < star; j++)
                System.out.print("*");
            for (int j = 0; j < space; j++)
                System.out.print(" ");
            System.out.print("\n");
        }
        for (int j = 0; j < starCount; j++)
            System.out.print("*");
    }
}
