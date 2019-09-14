import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("hello world");
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        System.out.println(x);
        for (int i = 0; i < 10; i++)
            System.out.println(i);
        int i = 0;
        while (i < 10) {
            if (i++ % 2 == 0)
                System.out.println(i);
        }
        do {
            i++;
            System.out.println(i);
        } while (i < 10);
    }
}
