package �ǥ�2;

import java.util.Scanner;

public class StudentSystem {
        
        public static void main (String[] args){
                
                Scanner input = new Scanner(System.in);
                
                System.out.println("�п�J�ǥͤH��: ");
                StudentInformation[] amount = new StudentInformation[input.nextInt()]; 
                
                System.out.println("�Ш̧ǿ�J�����B�魫�B���Z�B�Ǹ�: ");
                
                for ( int i = 0; i < amount.length; i++ ) {
                        //������ڳo��� "input.nextLine();" �|�S��k��JID��?
                        amount[i] = new StudentInformation( input.nextInt(), input.nextInt(), input.nextInt(), input.next() );
                }
                
                for ( int a = amount.length-1; a >= 0; a-- ) {
                        for ( int b = 0; b < a; b++ ) {
                                if ( amount[b].getGrade() > amount[a].getGrade() ) {
                                        StudentInformation tmp = amount[a];
                                        amount[a] = amount[b];
                                        amount[b] = tmp;
                                } 
                        }
                }
                
                for ( int i = 0; i < amount.length; i++ ) 
                        System.out.println( amount[i] );
                
        }
}
