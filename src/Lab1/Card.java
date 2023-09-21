package Lab1;

import java.util.Random;

public abstract class Card implements BalanceProvider{
    private final StringBuffer cardNumber = new StringBuffer();
    public Card() {
        Random random = new Random();
        for(int i = 1; i <= 16; i++){
            this.cardNumber.append(random.nextInt(10));
            if(i % 4 == 0 && i != 16) {
                this.cardNumber.append(" ");
            }
        }
        System.out.println("Your new card number is: " + getCardNumber());
    }
    public StringBuffer getCardNumber() {
        return cardNumber;
    }
}
