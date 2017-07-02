package 學生2;

import java.util.Arrays;
import java.util.Scanner;

public class StudentSystem {
        
        public static void main (String[] args){
                
                Scanner input = new Scanner(System.in);
                CompareByGrade compare = new CompareByGrade();
                
                System.out.println("請輸入學生人數: ");
                Student[] amount = new Student[input.nextInt()]; 
                
                System.out.println("請依序輸入身高、體重、成績、學號: ");
                
                for ( int i = 0; i < amount.length; i++ ) {
                        amount[i] = new Student( input.nextInt(), input.nextInt(), input.nextInt(), input.nextLine() );
                }
                
                Arrays.sort(amount, compare);
                
                for ( int i = 0; i < amount.length; i++ ) 
                        System.out.println( amount[i] );
                
        }
}
