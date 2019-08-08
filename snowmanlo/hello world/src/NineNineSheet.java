public class NineNineSheet {
    public static void main(String[] args) {
        for (int i = 1; i < 10; i++) {
            for (int j = 1; j < 10; j++) {
                if (j * i / 10 >= 1)
                    System.out.print(j + "*" + i + "=" + i*j + "  ");
                else
                    System.out.print(j + "*" + i + "=" + i*j + "   ");
            }
            System.out.print("\n");
        }

    }
}
