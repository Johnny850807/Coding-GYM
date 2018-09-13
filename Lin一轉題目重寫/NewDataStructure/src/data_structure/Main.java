package data_structure;

import exception.StackIsEmptyException;

import java.util.Comparator;

public class Main {
    public static void main(String[] args){
        Comparator<Student> myComparator = new LinComparator();  //自製 Comparator
        LinStack<Student> myStack = new LinStack<Student>(myComparator);  //宣告

        try{
            for ( int i = 0 ; i < 10 ; i ++ )  //放入1~10 學生
                myStack.push(new Student(i));

            for (Student student : myStack)  // for-each走訪印出
                System.out.print(student + " ");

            System.out.println();

            while(true)  //故意無限 pop 來觸發例外
            {
                Student nextStudent = myStack.pop();
                System.out.print(nextStudent + " ");  //看看是否跟走訪的順序一樣
            }

        }catch(StackIsEmptyException err){
            System.out.println(err.getMessage());
        }
    }
}
