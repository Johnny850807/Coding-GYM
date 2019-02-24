package member.nyngwang.students;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Collections;

public class Main {
	public static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {
		List<Student> students = new ArrayList<Student>();
		
		int numberOfStudents = 0;
		numberOfStudents = scan.nextInt();
		
		for (int i = 1; i <= numberOfStudents; i++) {
			int height = scan.nextInt();
			int weight = scan.nextInt();
			int grade = scan.nextInt();
			String id = scan.nextLine();
			
			students.add(new Student(height, weight, grade, id));
			
		}
		
		Collections.sort(students, new StudentGradeComparator());
		
		for (Student student: students) {
			System.out.println(student);
		}

	}
	
}
