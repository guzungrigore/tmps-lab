package Lab1;

interface BalanceProvider {
    double getBalance();
    void deposit(double amount);
    int withdraw(double amount);
}
