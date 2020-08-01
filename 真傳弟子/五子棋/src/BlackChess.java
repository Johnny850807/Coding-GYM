import java.util.Scanner;

public class BlackChess extends Chess {

    String name;

    public BlackChess(String name){
        this.name = name;
    }

    @Override
    public int[] playchess() {
        Scanner play = new Scanner(System.in);
        int [] select= new int [2];

        String coordinate = play.next();
        select [0] = Integer.parseInt(coordinate.split(",")[0]);
        select [1] = Integer.parseInt(coordinate.split(",")[1]);

        return select;
    }

    @Override
    String getName() {
        return name;
    }
}
