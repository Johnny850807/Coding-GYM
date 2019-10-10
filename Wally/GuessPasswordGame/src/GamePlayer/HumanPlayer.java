package GamePlayer;

import GameException.GuessPasswordOverValieRangeException;

public class HumanPlayer extends Player {

    public void setName() {
        System.out.print("[設定] 玩家名字 : ");
        name = scanner.nextLine();
    }

    @Override
    public int guessPassword(int belowNumber, int topNumber) {
        while (true) {
            try {
                System.out.print("[輸入] 請 " + name + " 輸入猜測密碼 : ");
                int guessPassword = Integer.parseInt(scanner.nextLine());
                if (guessPassword <= belowNumber || guessPassword >= topNumber) {
                    throw new GuessPasswordOverValieRangeException();
                }
                return guessPassword;
            } catch (NumberFormatException e) {
                System.out.println("[錯誤] 請輸入數字 ");
            } catch (GuessPasswordOverValieRangeException e) {
                System.out.println("[錯誤] 請輸入範圍內數字 ");
            }
        }
    }
}
