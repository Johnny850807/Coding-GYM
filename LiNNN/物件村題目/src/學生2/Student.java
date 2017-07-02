package ¾Ç¥Í2;

public class Student {
        private int height;
        private int weight;
        private int grade;
        private String id;
        
        public Student ( int height, int weight, int grade, String id ) { 
                this.height = height;
                this.weight = weight;
                this.grade = grade;
                this.id = id;
        }
        
        @Override
        public String toString() {
                return "Student [height=" + height + ", weight=" + weight + ", grade=" + grade + ", id=" + id + "]";
        }
        
        public int getGrade() {
                return grade;
        }
        public void setGrade(int grade) {
                this.grade = grade;
        }

}
