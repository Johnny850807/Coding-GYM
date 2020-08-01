import java.util.Scanner;

public class Main {

    public static final int Triangle = 1;
    public static final int Square = 2;
    public static final int Circle = 3;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("請選擇您要的形狀 1.三角形 2.正方型 3.圓形");
        switch (sc.nextInt()){
            case 1:
                Triangle tri = new Triangle();
                tri.input();
            case 2:
                Square squ = new Square();
                squ.input();
            case 3:
                Circle cir = new Circle();
               cir.input();

        }
    }
}
