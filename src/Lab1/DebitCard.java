package Lab1;

public class DebitCard extends Card{
    private double balance;

    public DebitCard() {
        super();
        this.balance = 0;
    }

    @Override
    public double getBalance() {
        return balance;
    }

    @Override
    public void deposit(double amount) {
        balance += amount;
    }

    @Override
    public int withdraw(double amount) {
        if (this.balance >= amount) {
            System.out.println("Withdrawing " + amount + " using Debit Card.");
            this.balance -= amount;
            return 1;
        } else {
            System.out.println("Insufficient balance.");
            return -1;
        }
    }
}
