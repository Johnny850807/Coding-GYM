/**
 * @author i19
 */
public class CountTriangle implements Shape {
    private double bottom;
    private double height;

    @Override
    public void inputShapeParameter() {
        System.out.println("輸入底、高：");
        bottom = IN.nextDouble();
        height = IN.nextDouble();
    }

    @Override
    public double calculation() {
        return bottom * height / 2;
    }
}


