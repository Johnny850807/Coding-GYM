package Landmine;

import java.util.Scanner;


public class MainFunction {

    public static void main(String[] argv) {

        Scanner sc = new Scanner(System.in);
        String answer;
        do{
            System.out.println("請輸入踩地雷大小:");
            int size = sc.nextInt();
            System.out.println("請輸入地雷數量:");
            int count = sc.nextInt();
            new Board(size,count).startGame();

            System.out.println("\n是否要再來一場?(y/n):");

            answer = sc.next();

        }while (answer.equals("y"));

        System.out.print("遊戲結束");
    }
}
