package �ǥ�2;

import java.util.Arrays;
import java.util.Scanner;

public class StudentSystem {
        
        public static void main (String[] args){
                
                Scanner input = new Scanner(System.in);
                CompareByGrade compare = new CompareByGrade();
                
                System.out.println("�п�J�ǥͤH��: ");
                Student[] amount = new Student[input.nextInt()]; 
                
                System.out.println("�Ш̧ǿ�J�����B�魫�B���Z�B�Ǹ�: ");
                
                for ( int i = 0; i < amount.length; i++ ) {
                        amount[i] = new Student( input.nextInt(), input.nextInt(), input.nextInt(), input.nextLine() );
                }
                
                Arrays.sort(amount, compare);
                
                for ( int i = 0; i < amount.length; i++ ) 
                        System.out.println( amount[i] );
                
        }
}
