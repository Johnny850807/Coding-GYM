
public class RealPlayer extends Player {

	@Override
	public String named() {
		System.out.println("請輸入名稱: ");
		name = input.nextLine();
		return name;
	}

	@Override
	public int Choice() {
		System.out.print("請輸入欲選擇格子數(1~9): ");
		int choice = input.nextInt();
		return choice;
	}

}
