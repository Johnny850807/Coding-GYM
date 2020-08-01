import java.util.Comparator;

public class Main {
    public static void main(String[] args) throws PopException {
        Comparator<Student> comparator = new MyComparator();
        TestStack<Student> test = new TestStack<>(comparator);

        try{
            for ( int i = 0 ; i < 10 ; i ++ )  //放入1~10個學生
                test.push(new Student(i));

            for (Student student : test)  // for-each走訪印出
                System.out.print(student + " ");

            System.out.println();

            while(true)  //故意無限 pop 來觸發例外
            {
                Student nextStudent = test.pop();
                System.out.print(nextStudent + " ");  //看看是否跟走訪的順序一樣
            }

        }catch(PopException err){
            System.out.println(err.getMessage());
        }

    }
}

