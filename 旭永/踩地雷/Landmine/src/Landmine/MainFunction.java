package Landmine;

import java.util.Scanner;


public class MainFunction {

    public static void main(String[] argv) {

        Scanner sc = new Scanner(System.in);
        String answer;
        do{
            System.out.println("�п�J��a�p�j�p:");
            int size = sc.nextInt();
            System.out.println("�п�J�a�p�ƶq:");
            int count = sc.nextInt();
            new Board(size,count).startGame();

            System.out.println("\n�O�_�n�A�Ӥ@��?(y/n):");

            answer = sc.next();

        }while (answer.equals("y"));

        System.out.print("�C������");
    }
}
