import java.awt.*;
public class Counter extends Thread
{
       private int second;
       private Controller controller;
       private Thread meTime;
       public Counter(Controller controller)
       {
           this.controller = controller;
           this.second = controller.getModel().getSecond();
           this.meTime = this;
       }
       public void run()
       {
           while(Thread.currentThread() == meTime)
           {
               try { Thread.sleep(1000);}
               catch(InterruptedException e){System.out.println("延遲出現錯誤!!");}
               count();
           }
       }
       public void count()
       {
           if(second==0)
           {
               pause();
           }
           else
           {
               second--;
               controller.getModel().setSecond(second);
           }
       }
       public void pause()
       {
           meTime = null;
           System.out.println("遊戲結束");
       }
}