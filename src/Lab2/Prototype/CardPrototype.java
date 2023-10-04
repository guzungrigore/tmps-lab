package Lab2.Prototype;

import Lab1.Card;

public class CardPrototype {
    private static Card originalCard;

    public static void setOriginalCard(Card card) {
        originalCard = card;
    }

    public static Card cloneCard() {
        try {
            return (Card) originalCard.clone();
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }
}
