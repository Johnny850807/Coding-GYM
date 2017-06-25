package 面積2;

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
                        System.out.println("1.圓形 2.三角形 3.矩形 4.Exit...");
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
                                System.out.println("歡樂的時光總是特別快，又到了時候說掰掰");
                                System.out.println("我是墨水球，我們  下次見");
                                i = 0;
                                
                        }
                }
                
        }
}
