package Lab2.Factory;

import Lab1.Card;
import Lab1.CreditCard;

public class CreditBank implements Bank{
    @Override
    public Card createCard() {
        return new CreditCard(1000, 0.1);
    }
}
