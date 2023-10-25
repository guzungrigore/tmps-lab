package Lab3.Decorator;

import Lab1.Card;
import Lab1.Transaction;


public class LoggingTransactionDecorator implements Transaction {
    private Transaction transaction;

    public LoggingTransactionDecorator(Transaction transaction) {
        this.transaction = transaction;
    }

    @Override
    public void transaction(Card fromCard, Card toCard, double amount) {
        System.out.println("Logging: Transaction started");
        transaction.transaction(fromCard, toCard, amount);
        System.out.println("Logging: Transaction completed");
    }
}
