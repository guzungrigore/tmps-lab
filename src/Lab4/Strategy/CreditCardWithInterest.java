package Lab4.Strategy;

import Lab1.CreditCard;

// Context
public class CreditCardWithInterest extends CreditCard {
    private final InterestCalculationStrategy interestStrategy;

    public CreditCardWithInterest(int initialSum, double rate, InterestCalculationStrategy interestStrategy) {
        super(initialSum, rate);
        this.interestStrategy = interestStrategy;
    }

    public void applyInterest() {
        double interest = interestStrategy.calculateInterest(getBalance());
        deposit(interest);
        System.out.println("Interest applied: " + interest);
    }
}
