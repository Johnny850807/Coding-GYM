package Landmine;
import java.util.Random;
import java.util.Scanner;

public class Board implements Item{

    private int size, count;
    private int normalGrid;
    private Grid[][] items;
    private boolean isOver=false;

    Board(int size, int count) {
        this.size = size;
        this.count = count;
        initLandmine();
        normalGrid = (size*size)-count;
        updateView();
        System.out.println("---------------遊戲開始---------------");

    }

    private void initLandmine() {

        //set Grid
        items = new Grid[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                items[i][j] = new Grid();
            }
        }

        //set Landmine
        while (count != 0) {
            Random ran = new Random();
            int x = ran.nextInt(size);
            int y = ran.nextInt(size);
            //地雷位置
            //System.out.println("x ="+x+"   y="+y);
            if (!items[x][y].isLandmine()) {
                items[x][y].setLandmine(true);
                count--;
            }
        }
    }

    public void startGame() {

        Scanner sc = new Scanner(System.in);

        while (!isOver) {
            System.out.println("請輸入欲選擇格子座標(y/x):");

            int y ,x;
            y = sc.nextInt();
            x = sc.nextInt();

            if(x < 0 || y<0 || x > size-1 || y> size-1) {
                System.out.println("輸入超出範圍 請重新輸入");
                continue;
            }
            tread(y, x);
        }
    }


    public void tread(int y, int x) {
        items[y][x].setStepped(true);
        if(items[y][x].isLandmine()) {
            System.out.println("====== 踩到地雷了 !!!! 遊戲結束 ======");
            print();
            isOver = true;
        }else{
            updateItemStatus(y,x);
            if(!checkIsPass()){
                updateView();
            }else{
                isOver = true;
            }
        }

    }

    private boolean checkIsPass(){
        normalGrid-=1;
        if(normalGrid==0) {
            System.out.println("恭喜過關了RRRRRRRRRRRRRRRRRRRRR!!!");
            print();
            return true;
        }
        return false;
    }

    private void updateView() {
        System.out.print("\n\n\t");
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if(i == 0) {
                    System.out.print(j+"\t");
                }
            }
            System.out.print("\n"+i + "\t");
            for(int k =0 ;k<size;k++) {
                items[i][k].print();
            }
            System.out.print("\n");
        }
    }


    //檢查周圍
    private void updateItemStatus(int y,int x) {

        int landmineCount=0;

        for(int n =y-1;n<=y+1;n++) {
            for (int m = x - 1; m <= x + 1; m++) {
                if ( n>=0 && n <= size-1 && m<=size-1 && m>=0) {
                    if(items[n][m].isLandmine()){
                        landmineCount++;
                    }
                }
            }
        }
        items[y][x].setStatus(String.valueOf(landmineCount));
    }


    @Override
    public void print() {
        for (int i = 0; i < size; i++) {
            for (int k = 0; k < size; k++) {
                items[i][k].setStepped(true);
                if(!items[i][k].isLandmine()){
                    updateItemStatus(i, k);
                }
            }
        }
        updateView();
    }
}
