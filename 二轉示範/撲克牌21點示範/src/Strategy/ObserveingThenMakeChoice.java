package Strategy;

import Player.Player;

public class ObserveingThenMakeChoice implements ChoiceStrategy{

	@Override
	public boolean makeChoiceToReceiveNextCardOrNot(Player player) {
		//TODO 這個策略原本想寫 具有觀察能力的AI 結果懶惰不寫了 廢墟類別一個
		return false;
	}

}
