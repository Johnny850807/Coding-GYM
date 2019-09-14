
public class CloseTimeCounter implements Runnable {
    public void run() {
        System.out.println("餐廳開始營業了");
        System.out.println("時間計時2分鐘開始");
        try {
            for (int i = 2; i > 0; i--) {
                System.out.println("時間還剩" + i + "分鐘");
                Thread.sleep(60 * 1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
