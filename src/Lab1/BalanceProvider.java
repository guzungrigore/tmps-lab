package Lab1;

public interface BalanceProvider {
    double getBalance();
    void deposit(double amount);
    int withdraw(double amount);
}
