package Strategy;

import Player.Player;

// 將思考策略封裝成物件，每個策略都用一種演算法決定是否再拿下一張卡。 (Strategy pattern)
public interface ChoiceStrategy {
	boolean makeChoiceToReceiveNextCardOrNot(Player player);
}
