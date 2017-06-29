package 學生2;

import java.util.Scanner;

public class StudentSystem {
        
        public static void main (String[] args){
                
                Scanner input = new Scanner(System.in);
                
                System.out.println("請輸入學生人數: ");
                StudentInformation[] amount = new StudentInformation[input.nextInt()]; 
                
                System.out.println("請依序輸入身高、體重、成績、學號: ");
                
                for ( int i = 0; i < amount.length; i++ ) {
                        //為什麼我這邊用 "input.nextLine();" 會沒辦法輸入ID啊?
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
