import java.util.Scanner;

public class Main {
    public static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {

        Human man = new Man();
        Human woman = new Woman();
        String input = in.nextLine();
        int length = input.length();
        Human[] humans = new Human[length];

        for (int i = 0; i < length; i++) {
            char gender = Character.toLowerCase(input.charAt(i));
            if (gender == 'b') {
                humans[i] = man;
            } else if (gender == 'g') {
                humans[i] = woman;
            }
        }

        for (Human human : humans) {
            human.eat();
            human.sleep();
        }
    }
}
