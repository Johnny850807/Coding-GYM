package �G�Q�@�I�C��;

public class ComPlayer extends Player{
	public ComPlayer(String name)
	{
		super(name);
	}

	@Override
	boolean is_continue() {
		if(cash<=16)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
}
