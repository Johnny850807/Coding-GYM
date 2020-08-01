import java.util.Scanner;

public class Square extends Shape {

    private int weight;
    private int height;

    void input(){
        Scanner sc = new Scanner(System.in);
        System.out.println("您選擇的是正方形，請輸入長和寬");
        this.weight = sc.nextInt();
        this.height = sc.nextInt();
    }

    @Override
    void CountArea() {
        area = weight*height;
        System.out.println(area);
    }
}
