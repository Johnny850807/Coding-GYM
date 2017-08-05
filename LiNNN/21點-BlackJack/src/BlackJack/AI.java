package BlackJack;

public class AI extends Player {

	@Override
	public String named() {
		String[] AI_Name = { "武藤遊戲", "海馬瀨人", "喪家犬城之內", "孔雀舞", "羽蛾", "漠良", "yellow大謙", "Bang結石", "曾淦傑", "黃+尾", "墨水球",
				"鯉開灰", "吹豐雞", "張援鬆", "小瓜呆<3" };
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
