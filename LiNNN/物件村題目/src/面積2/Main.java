package ���n2;

import java.util.Scanner;

import javax.print.DocFlavor.INPUT_STREAM;

public class Main {
        
        public static void main (String[] args){
           
                Scanner input = new Scanner(System.in);
                Circle circle = new Circle();
                Triangle triangle = new Triangle();
                Rectangle rectangle = new Rectangle();
                int i = 1;
                
                while (i != 0){
                        System.out.println("1.��� 2.�T���� 3.�x�� 4.Exit...");
                        int num = input.nextInt();
                        
                        switch(num){
                        case 1:
                                circle.Area();
                                break;
                        case 2:
                                triangle.Area();
                                break;
                        case 3:
                                rectangle.Area();
                                break;
                        case 4:
                                System.out.println("�w�֪��ɥ��`�O�S�O�֡A�S��F�ɭԻ��T�T");
                                System.out.println("�ڬO�����y�A�ڭ�  �U����");
                                i = 0;
                                
                        }
                }
                
        }
}
