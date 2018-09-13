import exception.BalanceIsNotEnoughException;

public class Bank {
    private int balance = 10000;
    private int expense = 0;
    private int income = 10000;

    public Bank() {
    }

    public synchronized void deposit(int depositMoney) throws InterruptedException {
        if (hasBalance()) {
            balance += depositMoney;
            income += depositMoney;
            System.out.println("User " + Thread.currentThread().getName() + " deposit " + depositMoney + " dollars");
            Thread.sleep(100);
        }
    }

    public synchronized void withdraw(int withdrawMoney) throws InterruptedException {
        if (hasBalance()) {
            int money = balance < withdrawMoney ? balance : withdrawMoney;
            balance -= money;
            expense += money;
            System.out.println("User " + Thread.currentThread().getName() + " withdraw " + withdrawMoney + " dollars");
            Thread.sleep(100);
        } else
            throw new BalanceIsNotEnoughException();
    }

    private boolean hasBalance() {
        return balance > 0;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public int getExpense() {
        return expense;
    }

    public void setExpense(int expense) {
        this.expense = expense;
    }

    public int getIncome() {
        return income;
    }

    public void setIncome(int income) {
        this.income = income;
    }
}
