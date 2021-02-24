/**
 * @author i19
 */
public class CountRectangle implements Shape {
    private double length;
    private double width;

    @Override
    public void inputShapeParameter() {
        System.out.println("輸入長、寬：");
        length = IN.nextDouble();
        width = IN.nextDouble();
    }

    @Override
    public double calculation() {
        return length * width;
    }
}


