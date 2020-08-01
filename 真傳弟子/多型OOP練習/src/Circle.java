import java.util.Scanner;

public class Circle extends Shape {

    private int radius;

    void input() {
        Scanner sc = new Scanner(System.in);
        System.out.println("您選擇的是圓形，請輸入半徑");
        this.radius = sc.nextInt();
    }

    @Override
    void CountArea() {
        area = (int) (radius * 3.14);
        System.out.println(area);
    }
}

