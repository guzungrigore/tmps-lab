package Lab4.Observer;

import Lab1.BalanceProvider;

import java.util.ArrayList;
import java.util.List;

// Observable class
public class ObservableCard implements BalanceProvider {
    private final List<BalanceObserver> observers = new ArrayList<>();
    private double balance;

    @Override
    public double getBalance() {
        return balance;
    }

    @Override
    public void deposit(double amount) {
        balance += amount;
        notifyObservers();
    }

    @Override
    public int withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            notifyObservers();
            return 1;
        } else {
            return -1;
        }
    }

    // Observer management methods
    public void addObserver(BalanceObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(BalanceObserver observer) {
        observers.remove(observer);
    }

    private void notifyObservers() {
        for (BalanceObserver observer : observers) {
            observer.updateBalance(balance);
        }
    }
}
