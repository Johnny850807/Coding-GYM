package ���n2;

public class Rectangle extends Shape{
        
        @Override
        public void Area(){
                System.out.println("�п�J���B�e: ");
                double length = input.nextDouble();
                double width = input.nextDouble();
                
                double area = length * width;
                
                System.out.println("���n = " + area);
        }

}
