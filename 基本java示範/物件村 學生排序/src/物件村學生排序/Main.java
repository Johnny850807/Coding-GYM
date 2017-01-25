package 物件村學生排序;

import java.util.Scanner;

public class Main {

	private static Scanner scanner = new Scanner(System.in);;

	public static void main(String[] args) {
		Student[] students = new Student[ scanner.nextInt() ];
		
		//輸入
		for ( int i = 0 ; i < students.length ; i ++ )
			students[i] = new Student( scanner.nextInt() , scanner.nextInt() , 
					scanner.nextInt() , scanner.nextLine() );
		
		//Bubble sort
		for ( int i = 0 ; i < students.length - 1 ; i ++ )
			for ( int j = i + 1 ; j < students.length ; j ++ )
				if ( students[i].getGrades() > students[j].getGrades() )
				{
					//交換
					Student temp = students[j];
					students[j] = students[i];
					students[i] = temp;
				}
		
		//印出 foreach
		for ( Student s : students )
			System.out.println(s);
		
	}

}
