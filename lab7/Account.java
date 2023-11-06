public class Account {
    private double balance;

    // constructor
    public Account() {
        this.balance = 0;
    }

    // getter

    public double getBalance() {
        return balance;
    }

    // methods

    public void deposit(double amount) {
        this.balance += amount;
        System.out.println("new balance: " + balance + "$");

    }

    public void withdraw(double amount) throws NotEnoughMoneyException {
        if (amount > balance) {
            throw new NotEnoughMoneyException(amount, balance);
        }
        balance -= amount;
        System.out.println("new balance: " + balance + "$");

    }

}
