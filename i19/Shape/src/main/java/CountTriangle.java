/**
 * @author i19
 */
public class CountTriangle implements Shape{
    @Override
    public double calculation() {
        System.out.println("輸入底、高：");
        double bottom = IN.nextDouble();
        double height = IN.nextDouble();
        double result =  bottom * height / 2;
        return (double) Math.round(result * 100)/100;
    }
}


