package Lab1;

public class CreditCard extends Card{
    private final int creditLimit;
    private double balance;

    public CreditCard(int creditLimit) {
        super();
        this.creditLimit = creditLimit;


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
        if (getBalance() + creditLimit >= amount) {
            System.out.println("Withdrawing " + amount + " using Credit Card.");
            deposit(-amount);
        } else {
            System.out.println("Insufficient balance and credit limit.");
        }
    }
}
