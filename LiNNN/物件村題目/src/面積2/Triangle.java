package ���n2;

public class Triangle extends Shape{
        
        @Override
        public void Area(){
                System.out.println("�п�J���B��");
                double length = input.nextDouble();
                double height = input.nextDouble();
                
                double area = length * height / 2;
                
                System.out.println("���n = " + area);
                
        }
}
