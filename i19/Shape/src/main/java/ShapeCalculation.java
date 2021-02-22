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

    public double countResult(Shape shape){
        if(shape == null){
            this.shape = new CountCircle();
        }
        return this.shape.calculation();
    }
}


