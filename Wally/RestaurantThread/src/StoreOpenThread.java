
public class StoreOpenThread implements Runnable{

	private final int oneMinute = 60 ;

	public StoreOpenThread() {
		System.out.println("餐廳開始營業了");		
	}

	public void run() {
		
		System.out.println("時間計時2分鐘開始");
		
		try {
			
			for (int i = 2; i > 0 ; i--) {
						
				System.out.println("時間還剩"+ i +"分鐘");
				
				Thread.sleep(oneMinute*1000);
			}
		} catch (InterruptedException e) {
			System.out.println("Thread is stop !!");
		}
	}

}
