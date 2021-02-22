import java.util.Scanner;

/**
 * @author i19
 */
public class Main {
    private static final Shape[] SHAPES = new Shape[]{null,
            new CountCircle(),
            new CountRectangle(),
            new CountTriangle()
    };

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("使用者首先決定要計算何種形狀的面積：\n" +
                "(1) 圓形 (2) 矩形 (3) 三角形");
        Shape shape = SHAPES[in.nextInt()];
        ShapeCalculation shapeCalculation = new ShapeCalculation(shape);
        shapeCalculation.setShape(shape);
        System.out.println(shapeCalculation.countResult(shape));
    }
}


