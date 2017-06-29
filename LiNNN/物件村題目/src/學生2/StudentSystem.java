package �ǥ�2;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Comparator;

public class StudentSystem {
        
        public static void main (String[] args){
                
                Scanner input = new Scanner(System.in);
                
                System.out.println("�п�J�ǥͤH��: ");
                StudentInformation[] amount = new StudentInformation[input.nextInt()]; 
                
                System.out.println("�Ш̧ǿ�J�����B�魫�B���Z�B�Ǹ�: ");
                
                for ( int i = 0; i < amount.length; i++ ) {
                        amount[i] = new StudentInformation( input.nextInt(), input.nextInt(), input.nextInt(), input.nextLine() );
                }
                
                class CompareByGrade implements Comparator{
                        @Override
                        public int compare(Object o1, Object o2) {
                                int grade1 = ((StudentInformation)o1).getGrade();
                                int grade2 = ((StudentInformation)o2).getGrade();
                                if ( grade1 > grade2)
                                        return 1;
                                if (grade1 < grade2)
                                        return -1;
                                return 0;
                        }
                };
                
                Arrays.sort(amount, new CompareByGrade());
                
                for ( int i = 0; i < amount.length; i++ ) 
                        System.out.println( amount[i] );
                
        }
}
