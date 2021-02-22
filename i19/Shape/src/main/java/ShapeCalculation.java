/**
 * @author i19
 */
public class ShapeCalculation {
    private Shape shape;

    public void setShape(Shape shape) {
        this.shape = shape;
    }

    public ShapeCalculation(Shape shape) {
        this.shape = shape;
    }

    public double countResult(Shape shape, int bit) {
        double pow = Math.pow(10, bit);
        if (shape == null) {
            this.shape = new CountCircle();
        }
        double shapeCount = this.shape.calculation();
        return (double) Math.round(shapeCount * pow) / pow;
    }
}


