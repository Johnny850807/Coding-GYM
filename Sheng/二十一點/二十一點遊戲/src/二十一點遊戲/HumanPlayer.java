package 二十一點遊戲;
import java.util.Scanner;
public class HumanPlayer extends Player{

	public HumanPlayer(String name)
	{
		super(name);
	}

	@Override
	boolean is_continue() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("是否要下一張?(y/n)");
		if(scanner.nextLine().equals("y"))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
}
