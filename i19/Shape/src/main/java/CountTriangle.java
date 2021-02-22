/**
 * @author i19
 */
public class CountTriangle implements Shape {
    @Override
    public double calculation() {
        System.out.println("輸入底、高：");
        double bottom = IN.nextDouble();
        double height = IN.nextDouble();
        return bottom * height / 2;
    }
}


