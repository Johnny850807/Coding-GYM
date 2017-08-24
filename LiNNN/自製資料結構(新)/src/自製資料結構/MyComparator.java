package 自製資料結構;

import java.util.Comparator;

public class MyComparator implements Comparator<Student>{

	@Override
	public int compare(Student o1, Student o2) {
		if (o1.getNumber() > o2.getNumber())
			return 1;
		if (o1.getNumber() < o2.getNumber())
			return -1;
		return 0;
	}
	
}