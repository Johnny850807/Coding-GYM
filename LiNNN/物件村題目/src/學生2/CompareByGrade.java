package ¾Ç¥Í2;

import java.util.Comparator;

public class CompareByGrade implements Comparator{
         @Override
         public int compare(Object o1, Object o2) {
                 int grade1 = ((Student)o1).getGrade();
                 int grade2 = ((Student)o2).getGrade();
                 if ( grade1 > grade2)
                         return 1;
                 if (grade1 < grade2)
                         return -1;
                 return 0;
         }
};
