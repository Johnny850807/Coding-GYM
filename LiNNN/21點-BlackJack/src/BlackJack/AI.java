package BlackJack;

public class AI extends Player {

	@Override
	public String named() {
		String[] AI_Name = { "�Z�ùC��", "�����u�H", "��a��������", "�ճ��R", "�и�", "�z�}", "yellow�j��", "Bang����", "���h��", "��+��", "�����y",
				"�U�}��", "�j����", "�i���P", "�p�ʧb<3" };
		int i = (int) (Math.random() * (AI_Name.length));

		return AI_Name[i];

	}

	@Override
	public boolean choice(int point) throws InterruptedException {

		if (21 - point < 5) {
			int i = (int) (Math.random() * 1000 + 2000);
			Thread.sleep(i);
			System.out.println("N");
			return false;
		} else {
			int i = (int) (Math.random() * 500 + 1000);
			Thread.sleep(i);
			System.out.println("Y");
			return true;
		}

	}

}
