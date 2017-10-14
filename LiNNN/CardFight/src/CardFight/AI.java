package CardFight;

import CardStack.Card;

public class AI extends Player {

	public AI() {
		super();
	}

	@Override
	public void named() {
		String[] AI_Name = { "�Z�ùC��", "�����u�H", "��a��������", "�ճ��R", "�и�", "�z�}", "yellow�j��", "Bang����", "���h��", "��+��", "�����y",
				"�U�}��", "�j����", "�i���P", "���� <3" };
		name = AI_Name[(int) (Math.random() * (AI_Name.length))];
	}

	public String getName() {
		return this.name;
	}

	@Override
	public Card fight() {
		handCards();
		int choice = (int) (Math.random() * 3 + 1);
		System.out.println(getName() + " ���X�F< " + handCards.get(choice - 1).getRank() + " >");
		return handCards.get(choice - 1);
	}

	@Override
	public void handCards() {
		draw();
	}

}
