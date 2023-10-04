package Lab2.Singleton;

import Lab1.*;

public class SingletonTransaction extends CardTransaction {
    private static SingletonTransaction instance;

    private SingletonTransaction(){
        // Private constructor to prevent instantiation
    }

    public static SingletonTransaction getInstance() {
        if (instance == null) {
            instance = new SingletonTransaction();
        }
        return instance;
    }

    @Override
    public void transaction(Card fromCard, Card toCard, double amount) {
        super.transaction(fromCard, toCard, amount);
    }
}
