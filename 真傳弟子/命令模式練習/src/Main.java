import Furniture.Fan;
import Furniture.Light;
import Furniture.Television;

import java.util.Scanner;

public class Main {
    private static Scanner input = new Scanner(System.in);
    private static Television television = new Television();
    private static Light light = new Light();
    private static Fan fan = new Fan();
    private static RemoteControl remoteControl = new RemoteControl();
    private static String select;

    public static void main(String[] args) {
        CommandFactory commandFactory = new CommandFactoryImpl(fan, light, television, remoteControl);
        remoteControl.setControlAbstractFactory(commandFactory);
        useRemoteControl();
        furnitureStatus();
    }

    public static void useRemoteControl() {
        do {
            System.out.println("請輸入指令(1~6)或End結束");
            select = input.next();
            if (select.equals("End")) {
                break;
            }
            try {
                remoteControl.useRemoteControl(Integer.parseInt(select));
            } catch (ControlCantUndoException e) {
                System.out.println(e.getMessage());
            }
        } while (true);

    }

    public static void furnitureStatus() {
        if (light.isTurnOn()) {
            System.out.println(("電燈  開啟"));
        }

        System.out.println("電燈  關閉");
        System.out.println("電風扇  " + fan.getStatusToString());
        System.out.println("電視頻道  " + television.getProgramNumber());

    }
}
