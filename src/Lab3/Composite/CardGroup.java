package Lab3.Composite;

import Lab1.BalanceProvider;
import Lab1.Card;

public interface CardGroup extends BalanceProvider {
    void addCard(Card card);
    void removeCard(Card card);
}
