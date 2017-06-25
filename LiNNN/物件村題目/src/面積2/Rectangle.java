package 面積2;

public class Rectangle extends Shape{
        
        @Override
        public void Area(){
                System.out.println("請輸入長、寬: ");
                double length = input.nextDouble();
                double width = input.nextDouble();
                
                double area = length * width;
                
                System.out.println("面積 = " + area);
        }

}
