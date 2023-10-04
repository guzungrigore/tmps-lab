package Lab2.Factory;

import Lab1.Card;
import Lab1.DebitCard;

public class DebitBank implements Bank{
    @Override
    public Card createCard() {
        return new DebitCard();
    }
}
