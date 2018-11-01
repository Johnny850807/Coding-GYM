
public class timeThread implements Runnable {

	@Override
	public void run() {
		
		while (true) {
			try {
				Thread.sleep(60000);
				System.out.println("It's been A minute");
			} catch (InterruptedException e) {
				System.out.println("Wake up");
			}
		}
	}

}
