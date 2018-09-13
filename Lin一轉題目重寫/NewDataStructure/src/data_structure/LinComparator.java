package data_structure;

import java.util.Comparator;

public class LinComparator implements Comparator<Student> {
    @Override
    public int compare(Student student1, Student student2) {
        return Integer.compare(student1.getNumber(), student2.getNumber());
    }
}
