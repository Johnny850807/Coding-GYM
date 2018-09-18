
public class RealPlayer extends Player {

	@Override
	public void nameSelf() {
		System.out.println("請輸入名稱: ");
		name = input.nextLine();
	}

	@Override
	public int choice() {
		System.out.print("請輸入欲選擇格子數(1~9): ");
		int choice = input.nextInt();
		return choice;
	}

}
