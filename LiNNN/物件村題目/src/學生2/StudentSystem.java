package 學生2;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Comparator;

public class StudentSystem {
        
        public static void main (String[] args){
                
                Scanner input = new Scanner(System.in);
                
                
                System.out.println("請輸入學生人數: ");
                Student[] amount = new Student[input.nextInt()]; 
                
                System.out.println("請依序輸入身高、體重、成績、學號: ");
                
                for ( int i = 0; i < amount.length; i++ ) {
                        amount[i] = new Student( input.nextInt(), input.nextInt(), input.nextInt(), input.nextLine() );
                }
              
                Comparator compare = new Comparator() {
                        public int compare(Object o1, Object o2) {
                                int grade1 = ((Student)o1).getGrade();
                                int grade2 = ((Student)o2).getGrade();
                                if ( grade1 > grade2)
                                        return 1;
                                if (grade1 < grade2)
                                        return -1;
                                return 0;
                        }
                };
                
                Arrays.sort(amount, compare);
                
                for ( int i = 0; i < amount.length; i++ ) 
                        System.out.println( amount[i] );
                
        }
}
