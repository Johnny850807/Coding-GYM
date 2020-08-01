import java.util.Comparator;

public class MyComparator implements Comparator<Student> {

    public MyComparator(){

    }

    @Override
    public int compare(Student o1, Student o2) {
        return o1.getNumber()-o2.getNumber();
    }
}
