package Lab1;

public class CreditCard extends Card{
    private final int initialSum;
    private double leftToPay;
    private final double rate;
    private double balance;

    public CreditCard(int initialSum, double rate) {
        super();
        this.initialSum = initialSum;
        this.rate = rate;
        this.leftToPay = initialSum * rate;
        this.balance = initialSum;
    }

    @Override
    public double getBalance() {
        return balance;
    }

    @Override
    public void deposit(double amount) {
        leftToPay -= amount;
        System.out.println("You have left to pay: " + this.leftToPay);
    }

    @Override
    public void withdraw(double amount) {
        if (this.balance >= amount) {
            System.out.println("Withdrawing " + amount + " using Credit Card.");
            balance -= amount;
        } else {
            System.out.println("Insufficient balance and credit limit.");
        }
    }
}