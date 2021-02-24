/**
 * @author i19
 */
public class CountCircle implements Shape {
    private double r;

    @Override
    public void inputShapeParameter() {
        System.out.println("輸入半徑：");
        r = IN.nextDouble();
    }

    @Override
    public double calculation() {
        return Math.pow(r, 2) * Math.PI;
    }
}


