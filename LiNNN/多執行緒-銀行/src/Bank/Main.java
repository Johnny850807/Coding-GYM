package Bank;

public class Main {

	public static void main(String[] args) {
		BankAccount bankAccount = new BankAccount();
		String[] userNames = { "������", "�Z�ý���", "�Ѯa����Ĥ�", "�Q�d�R~", "�ճ��R", "�и�", "�z�}", "yellow�j��", "Bang����", "���h��", "��+��",
				"�����y", "�U�}��", "�j����", "�i���P", "�p�ʧb<3" };

		for (int i = 0; i < 500; i++) {
			User user = new User(bankAccount);
			Thread userThread = new Thread(user);
			userThread.setName(userNames[(int) (Math.random() * userNames.length)]);
			userThread.start();
		}
	}

}
