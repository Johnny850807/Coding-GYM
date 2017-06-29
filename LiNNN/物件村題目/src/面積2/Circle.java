package 面積2;

public class Circle extends Shape {

        @Override
        public void Area(){
                System.out.println("請輸入半徑");
                double radius = input.nextDouble();
                
                double area = radius * radius * 3.14;
                
               System.out.println("面積 = " + area); 
               
        }
        
}
