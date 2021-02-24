import java.util.Scanner;

/**
 * @author i19
 */
public class Main {
    private static final Shape[] SHAPES = new Shape[]{
            new CountCircle(),
            new CountRectangle(),
            new CountTriangle()
    };

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        do {
            System.out.println("使用者首先決定要計算何種形狀的面積：\n" +
                    "(0) 圓形 (1) 矩形 (2) 三角形");
            Shape shape = SHAPES[in.nextInt()];
            System.out.println("你要四捨五入到第幾位?");
            int bit = in.nextInt();
            ShapeCalculation shapeCalculation = new ShapeCalculation(shape);
            System.out.println(shapeCalculation.countResult(bit));
            System.out.println("繼續計算(Y/N)");
        } while ("Y".equals(in.next().toUpperCase()));

    }
}


