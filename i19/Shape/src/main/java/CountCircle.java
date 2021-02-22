/**
 * @author i19
 */
public class CountCircle implements Shape{

    @Override
    public double calculation() {
        double result;
        System.out.println("輸入半徑：");
        double r = IN.nextDouble();
        result = Math.pow(r, 2) * Math.PI;
        return (double) Math.round(result*100)/100;
    }
}


