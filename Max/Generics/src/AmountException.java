
public class AmountException extends Exception{
	public AmountException(int x){
        super("零件不夠需要   : " + x  + "個");
   }
}
