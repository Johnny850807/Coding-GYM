import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Bank bank = new Bank();
        List<Thread> threads = new ArrayList<>();

        for (int i = 0; i < 1000; i++)
            threads.add(new Thread(new User(bank)));
        for (Thread thread : threads)
            thread.start();

        for(Thread thread : threads)
            thread.join();

        int result = bank.getIncome() - bank.getExpense();
        System.out.println("結論: 總和 " + bank.getIncome() + " - " + bank.getExpense() + " = " +result );
        System.out.println(result == 0 ? "Success" : "Fail");
    }
}
