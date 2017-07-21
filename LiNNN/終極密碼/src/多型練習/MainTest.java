package ¦h«¬½m²ß;

import java.util.Scanner;
import java.util.*;

import javax.accessibility.AccessibleStreamable;

public class MainTest {

        public static void main (String[] args){
                Scanner input = new Scanner(System.in);
                
                System.out.println("input: ");
                String str1 = input.next();
                ArrayList<Human>  humanList = new ArrayList<Human>();

                
                for ( int i = 0; i < str1.length(); i++ ) {
                        char s = str1.charAt(i);
                
                        if ( s == 'b' || s== 'B')
                                humanList.add( new Man() );
                        else
                                humanList.add( new Woman() );
                
                }
                
                for ( Human human : humanList ) {
                        human.eat();
                }
                
                for ( Human human : humanList ) {
                        human.sleep();
                }
                
        }
}
