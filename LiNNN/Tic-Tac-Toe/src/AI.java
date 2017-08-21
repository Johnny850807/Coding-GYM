
public class AI extends Player {

	@Override
	public void named() {
		String[] AI_Name = { "武藤遊戲", "海馬瀨人", "喪家犬城之內", "孔雀舞", "羽蛾", "漠良", "yellow大謙", "Bang結石", "曾淦傑", "黃+尾", "墨水球",
				"鯉開灰", "吹豐雞", "張援鬆", "小瓜呆<3" };
		name = AI_Name[(int) (Math.random() * (AI_Name.length))];
	}

	@Override
	public int choice() {
		int choice = (int) (Math.random() * 9 + 1);
		return choice;
	}

}
