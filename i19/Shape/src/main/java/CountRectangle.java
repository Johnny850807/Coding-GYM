/**
 * @author i19
 */
public class CountRectangle implements Shape {

    @Override
    public double calculation() {
        System.out.println("輸入長、寬：");
        double length = IN.nextDouble();
        double width = IN.nextDouble();
        return length * width;
    }
}


