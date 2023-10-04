package Lab2.Builder;

import Lab1.*;

public class CardBuilder {
    private Card card;

    public CardBuilder(CardType type) {
        if (type == CardType.DEBIT) {
            card = new DebitCard();

        } else if (type == CardType.CREDIT) {
            card = new CreditCard(1000, 2.5);

        }
    }

    public CardBuilder setBalance(double balance) {
        card.deposit(balance);
        return this;
    }

    public Card build() {
        return card;
    }
}

