
public class AI extends Player {

	@Override
	public String named() {
		String[] AI_Name = { "�Z�ùC��", "�����u�H", "��a��������", "�ճ��R", "�и�", "�z�}", "yellow�j��", "Bang����", "���h��", "��+��", "�����y",
				"�U�}��", "�j����", "�i���P", "�p�ʧb<3" };
		name = AI_Name[(int) (Math.random() * (AI_Name.length))];
		
		return name;
	}

	@Override
	public int Choice() {
		int choice = (int) (Math.random() * 9 + 1);
		return choice;
	}

}
