package 學生;

import java.util.Scanner;

public class StudentSystem {
	public static void main(String [] args) {
		Scanner input=new Scanner(System.in);
		System.out.println("輸入:");
		int studentAmount=input.nextInt();
		Student[] student=new Student[studentAmount];
		for(int i=0;i<studentAmount;i++) {
			int height=input.nextInt();
			int weight=input.nextInt();
			int grades=input.nextInt();
			String id=input.next();
			student[i]=new Student(height,weight,grades,id);
		}
		
		bubbleSort(student,studentAmount);

		System.out.println("輸出:");		
		for(int i=0;i<studentAmount;i++)
			student[i].print();
	}
	private static void bubbleSort(Student[] student,int studentAmount) {
		for(int i=0;i<studentAmount-1;i++) {
			for(int j=i+1;j<studentAmount;j++) {
				Student temp;
				int g1=student[i].getGrades();
				int g2=student[j].getGrades();
				if(g1>g2) {
					temp=student[i];
					student[i]=student[j];
					student[j]=temp;
				}
			}
		}
	}
}
