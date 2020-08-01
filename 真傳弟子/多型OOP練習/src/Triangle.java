import java.util.Scanner;

public class Triangle extends Shape {

    private int base;
    private int high;

    void input(){
        Scanner sc = new Scanner(System.in);
        System.out.println("您選擇的是三角形，請輸入底和高");
        this.base = sc.nextInt();
        this.high = sc.nextInt();
        this.CountArea();
    }

    @Override
    void CountArea() {
        area = base*high/2;
        System.out.println(area);
    }
}
