package Strategy;

import Player.Player;

// �N��ҵ����ʸ˦�����A�C�ӵ������Τ@�غt��k�M�w�O�_�A���U�@�i�d�C (Strategy pattern)
public interface ChoiceStrategy {
	boolean makeChoiceToReceiveNextCardOrNot(Player player);
}
