package Lab3.Composite;

import Lab1.Card;

import java.util.ArrayList;
import java.util.List;

public class CompositeCardGroup implements CardGroup{
    private List<Card> cards = new ArrayList<>();

    @Override
    public void addCard(Card card) {
        cards.add(card);
    }

    @Override
    public void removeCard(Card card) {
        cards.remove(card);
    }

    @Override
    public double getBalance() {
        double totalBalance = 0;
        for (Card card : cards) {
            totalBalance += card.getBalance();
        }
        return totalBalance;
    }

    @Override
    public void deposit(double amount) {
        for (Card card : cards) {
            card.deposit(amount);
        }
    }

    @Override
    public int withdraw(double amount) {
        for (Card card : cards) {
            card.withdraw(amount);
        }
        return 0;
    }
}
