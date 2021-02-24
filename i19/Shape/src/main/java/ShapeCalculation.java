/**
 * @author i19
 */
public class ShapeCalculation {
    private final Shape shape;

    public ShapeCalculation(Shape shape) {
        this.shape = shape;
    }

    public double countResult(int bit) {
        double pow = Math.pow(10, bit);
        this.shape.inputShapeParameter();
        double shapeCount = this.shape.calculation();
        return (double) Math.round(shapeCount * pow) / pow;
    }
}


