package polymorphism_test;
import java.util.Scanner;

public abstract class AI extends Player{

	@Override
	abstract void guess();

	abstract int  getguessnumber();
	
}
