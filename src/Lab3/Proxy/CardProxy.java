package Lab3.Proxy;

import Lab1.BalanceProvider;
import Lab1.Card;

import java.util.Scanner;

public class CardProxy implements BalanceProvider {
    private final Card card;
    private final String password;

    public CardProxy(Card card, String password) {
        this.card = card;
        this.password = password;
    }

    private void authenticate(String enteredPassword) {
        if (!enteredPassword.equals(password)) {
            throw new SecurityException("Authentication failed. Incorrect password.");
        }
    }

    @Override
    public double getBalance() {
        authenticateUser();
        return card.getBalance();
    }

    @Override
    public void deposit(double amount) {
        authenticateUser();
        card.deposit(amount);
    }

    @Override
    public int withdraw(double amount) {
        authenticateUser();
        return card.withdraw(amount);
    }

    private void authenticateUser() {
        System.out.print("Enter your password: ");
        Scanner scanner = new Scanner(System.in);
        String enteredPassword = scanner.nextLine();
        authenticate(enteredPassword);
    }
}
