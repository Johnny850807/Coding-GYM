import java.util.Scanner;

public class Main {
    public static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {

        String input = in.nextLine();
        int length = input.length();
        Human[] humans = new Human[length];

        for (int i = 0; i < length; i++) {
            char gender = Character.toLowerCase(input.charAt(i));
            if (gender == 'b') {
                humans[i] = new Man();
            } else if (gender == 'g') {
                humans[i] = new Woman();
            }
        }

        for (Human human : humans) {
            human.eat();
            human.sleep();
        }
    }
}
