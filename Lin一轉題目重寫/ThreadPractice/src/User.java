public class User implements Runnable {
    private Bank bank;
    private static final String[] NAMES = {"Min", "Pan", "Ana", "Woo", "Liu", "Ning"};
    private String name;

    public User(Bank bank) {
        this.bank = bank;
    }

    @Override
    public void run() {
        try {
            if (name == null)
                setupUserName();
            depositOrWithdrawMoney();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void setupUserName() {
        Thread.currentThread().setName(NAMES[(int) (Math.random() * NAMES.length)]);
    }

    private void depositOrWithdrawMoney() throws InterruptedException {
        if ( (int) (Math.random() * 2) == 0) {
            depositMoney();
        } else {
            withdrawMoney();
        }
    }

    private void withdrawMoney() throws InterruptedException {
        int withdrawMoney = (int) (Math.random() * 1200) + 1;
        bank.withdraw(withdrawMoney);
    }

    private void depositMoney() throws InterruptedException {
        int depositMoney = (int) (Math.random() * 500) + 1;
        bank.deposit(depositMoney);
    }

    @Override
    public String toString() {
        return "User " + name;
    }
}
