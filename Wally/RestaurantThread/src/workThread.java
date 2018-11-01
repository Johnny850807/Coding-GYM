
public class workThread implements Runnable {

	@Override
	public void run() {
		
		boolean isFinished = false ;
		
		while (!isFinished) {
		
			for	( int i = 0 ; i < 10 ; i++ ) {
			System.out.println("It's "+i+"round");	
			}
			
		}
	}

}
