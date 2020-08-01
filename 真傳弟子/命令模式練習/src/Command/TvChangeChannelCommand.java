package Command;

import Furniture.Television;

import java.util.Scanner;

public class TvChangeChannelCommand implements Command {
    private Scanner channelNumber = new Scanner(System.in);
    private int previousNumber;
    private Television television;

    public TvChangeChannelCommand(Television television) {
        this.previousNumber = television.getProgramNumber();
        this.television = television;
    }

    @Override
    public void use() {
        System.out.println("請輸入頻道");
        television.changeProgram(channelNumber.nextInt());
    }

    @Override
    public void undo() {
        television.changeProgram(previousNumber);

    }
}
