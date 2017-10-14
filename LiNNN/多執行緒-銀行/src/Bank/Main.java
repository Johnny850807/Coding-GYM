package Bank;

public class Main {

	public static void main(String[] args) {
		BankAccount bankAccount = new BankAccount();
		String[] userNames = { "墨海馬", "武藤調戲", "敗家犬橙汁內", "被卡嘶~", "孔雀舞", "羽蛾", "漠良", "yellow大謙", "Bang結石", "曾淦傑", "黃+尾",
				"墨水球", "鯉開灰", "吹豐雞", "張援鬆", "小瓜呆<3" };

		for (int i = 0; i < 500; i++) {
			User user = new User(bankAccount);
			Thread userThread = new Thread(user);
			userThread.setName(userNames[(int) (Math.random() * userNames.length)]);
			userThread.start();
		}
	}

}
