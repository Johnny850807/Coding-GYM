import java.util.Scanner;

public class Main {
    public static Scanner in = new Scanner(System.in);
    public static void main(String[] args) {

        Human man = new Man();
        Human woman = new Woman();
        String input = in.nextLine();

        for (int i = 0; i < input.length(); i++) {
            if(Character.toLowerCase(input.charAt(i)) == 'b'){
                man.eat();
                man.sleep();
            }else if(Character.toLowerCase(input.charAt(i)) == 'g'){
                woman.eat();
                woman.sleep();
            }
        }

    }
}
