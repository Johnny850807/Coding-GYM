import java.util.Scanner;

public class ChangeMoney {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("輸入金額");
        int money = scanner.nextInt();
        int hundredDollar = 0;
        int fiftyDollar = 0;
        int twentyDallar = 0;
        int tenDollar = 0;
        int fiveDollar = 0;
        int oneDollar = 0;

        if (money >= 100) {
            hundredDollar = money / 100;
            money = money - hundredDollar * 100 ;
        }
        if (money >= 50) {
            fiftyDollar = money / 50;
            money = money - fiftyDollar * 50;
        }
        if (money >= 20) {
            twentyDallar = money / 20;
            money = money - twentyDallar * 20;
        }
        if (money >= 10) {
            tenDollar = money / 10;
            money = money - tenDollar * 10;
        }
        if (money >= 5) {
            fiveDollar = money / 5;
            money = money - fiveDollar *5;
        }
        if (money >= 1) {
            oneDollar = money / 1;
            money = money - oneDollar * 1;
        }
        System.out.print(hundredDollar + " ");
        System.out.print(fiftyDollar + " ");
        System.out.print(twentyDallar + " ");
        System.out.print(tenDollar + " ");
        System.out.print(fiveDollar + " ");
        System.out.println(oneDollar + " ");
    }
}
