package Command;

import Furniture.Television;
import Util.Input;

public class ChangeTvProgramCommand implements Command{
	private int program;
	private Television tv;
	
	public ChangeTvProgramCommand(Television tv) {
		this.program = tv.getProgramNumber();
		this.tv = tv;
	}

	@Override
	public void execute() {
		int number = Input.nextInt("½Ð¿é¤JÀW¹D");
		tv.changeProgram(number);
	}

	@Override
	public void undo() {
		tv.changeProgram(program);
	}

}
