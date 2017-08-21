package Command;

import Exception.NoCommandException;

public class NoCommand implements Command{  //NullObject pattern

	@Override
	public void execute() {
		throw new NoCommandException("�S�����O");
	}

	@Override
	public void undo() {
		throw new NoCommandException("�L�k�٭�F");
	}

}
