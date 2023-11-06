public class NotEnoughMoneyException extends IllegalStateException {
    private double requestedAmount;
    private double currentBalance;

    // constructor
    public NotEnoughMoneyException(double requestedAmount, double currentBalance) {
        super("you have not enough money to withdraw " + requestedAmount + "$");
        this.requestedAmount = requestedAmount;
        this.currentBalance = currentBalance;
    }

    // getters

    public double getAmount() {
        return this.requestedAmount;
    }

    public double getBalance() {
        return this.currentBalance;
    }

    public double getMissingAmount() {
        return this.requestedAmount - this.currentBalance;
    }
}
