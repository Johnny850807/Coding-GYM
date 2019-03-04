package member.nyngwang.students;

import java.util.Comparator;

public class StudentGradeComparator implements Comparator<Student> {

	@Override
	public int compare(Student left, Student right) {
		return left.grade < right.grade ? -1 : left.grade == right.grade ? 0 : 1;
	}

}
