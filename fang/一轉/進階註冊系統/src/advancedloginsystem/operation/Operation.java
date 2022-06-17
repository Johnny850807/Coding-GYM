package advancedloginsystem.operation;

import advancedloginsystem.user.UserData;

import java.io.IOException;
import java.util.Scanner;

public interface Operation {
    void execute(UserData userData) throws IOException;
    Scanner input = new Scanner(System.in);
}
