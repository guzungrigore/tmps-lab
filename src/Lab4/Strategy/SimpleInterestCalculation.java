package Lab4.Strategy;

// Concrete Strategy
public class SimpleInterestCalculation implements InterestCalculationStrategy{
    private final double rate;

    public SimpleInterestCalculation(double rate) {
        this.rate = rate;
    }

    @Override
    public double calculateInterest(double balance) {
        return balance * rate;
    }
}
