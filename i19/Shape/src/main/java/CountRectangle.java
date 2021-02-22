/**
 * @author i19
 */
public class CountRectangle implements Shape {

    @Override
    public double calculation() {
        System.out.println("輸入長、寬：");
        double length = IN.nextDouble();
        double width = IN.nextDouble();
        double result = length * width;
        return (double) Math.round(result * 100) / 100;
    }
}


