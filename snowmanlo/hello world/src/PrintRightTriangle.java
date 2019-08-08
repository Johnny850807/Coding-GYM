import java.util.Scanner;

public class PrintRightTriangle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("輸入有幾層");
        int floor = scanner.nextInt();
        int i = 0;
        while (i < floor) {
            i++;
            for (int j = 0; j < i; j++)
                System.out.print("*");
            for (int space = floor - i, z = 0; z < space; z++)
                System.out.print(" ");
            System.out.print("\n");
        }
    }
}
