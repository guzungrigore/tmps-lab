package Lab1;

import java.util.ArrayList;
import java.util.List;

public class Account {
    private int accountId;
    private final List<Card> cards;

    public Account() {
        this.cards = new ArrayList<>();
    }

    public void setCards(Card cards) {
        this.cards.add(cards);
    }

    public List<Card> getCards() {
        return cards;
    }

    @Override
    public String toString() {
        return "Account{" +
                "cards=" + cards +
                '}';
    }
}
