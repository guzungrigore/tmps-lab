package Lab1;

public class DebitCard extends Card{
    private double balance;

    public DebitCard() {
        super();
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
    public void withdraw(double amount) {
        if (this.balance >= amount) {
            System.out.println("Withdrawing " + amount + " using Debit Card.");
            deposit(-amount);
        } else {
            System.out.println("Insufficient balance.");
        }
    }
}
