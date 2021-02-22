/**
 * @author i19
 */
public class CountCircle implements Shape {

    @Override
    public double calculation() {
        System.out.println("輸入半徑：");
        double r = IN.nextDouble();
        return Math.pow(r, 2) * Math.PI;
    }
}


