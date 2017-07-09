package 學生;

import java.util.Scanner;

public class StudentSystem {
	public static void main(String [] args) {
		Scanner input=new Scanner(System.in);
		System.out.println("輸入:");
		int x=input.nextInt();
		Student[] student=new Student[x];
		for(int i=0;i<x;i++) {
			student[i]=new Student();
			int height=input.nextInt();
			int weight=input.nextInt();
			int grades=input.nextInt();
			String id=input.next();
			student[i].setHeight(height);
			student[i].setWeight(weight);
			student[i].setGrades(grades);
			student[i].setId(id);
		}
		
		for(int i=0;i<x-1;i++) {
			for(int j=i+1;j<x;j++) {
				Student temp=new Student();
				int g1=student[i].getGrades();
				int g2=student[j].getGrades();
				if(g1>g2) {
					temp=student[i];
					student[i]=student[j];
					student[j]=temp;
				}
			}
		}

		System.out.println("輸出:");		
		for(int i=0;i<x;i++)
			student[i].print();
	}
}
