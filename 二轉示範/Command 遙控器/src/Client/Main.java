package Client;

import Exception.NoCommandException;
import Furniture.Fan;
import Furniture.Light;
import Furniture.Television;
import Util.Input;

public class Main {

	public static void main(String[] args) {
		RemoteControl remoteControl = new RemoteControl(new Light(), new Fan(), new Television());
		String command;  // 1~6 or End
		boolean end;
		do
		{
			command = Input.nextLine("�п�J���O(1~6)��End����");
			end = command.equalsIgnoreCase("end");
			try{
				if (!end)
				{
					int num = Integer.valueOf(command.trim());
					remoteControl.executeCommandNumber(num);
				}
			}catch(NoCommandException err){
				System.out.println(err.getMessage());
			}
			
		}while(!end);
		
		remoteControl.printStatus();
	}

}
