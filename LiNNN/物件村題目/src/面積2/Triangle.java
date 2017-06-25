package 面積2;

public class Triangle extends Shape{
        
        @Override
        public void Area(){
                System.out.println("請輸入長、高");
                double length = input.nextDouble();
                double height = input.nextDouble();
                
                double area = length * height / 2;
                
                System.out.println("面積 = " + area);
                
        }
}
